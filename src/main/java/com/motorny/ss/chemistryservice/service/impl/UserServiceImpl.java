package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.UserDto;
import com.motorny.ss.chemistryservice.mapper.UserMapper;
import com.motorny.ss.chemistryservice.model.Review;
import com.motorny.ss.chemistryservice.model.User;
import com.motorny.ss.chemistryservice.repository.UserRepository;
import com.motorny.ss.chemistryservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> reviewList = userRepository.findAll();

        return reviewList.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(long id) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElse(null);

        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User saveUser = userRepository.save(user);

        return userMapper.toUserDto(saveUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        return null;
    }
}
