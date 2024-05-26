package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.UserDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.UserMapper;
import com.motorny.ss.chemistryservice.model.User;
import com.motorny.ss.chemistryservice.repository.UserRepository;
import com.motorny.ss.chemistryservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
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

        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }

        User user = byId.get();

        return userMapper.toUserDto(user);
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User saveUser = userRepository.save(user);

        return userMapper.toUserDto(saveUser);
    }

    @Override
    public String deleteUser(long id) {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isPresent()) {
            userRepository.deleteById(id);
            return "User with id: " + id + " was successfully remover";
        } else {
            log.error("User not found with id {}", id);
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());

        userRepository.save(existingUser);

        return userMapper.toUserDto(existingUser);
    }

    @Transactional
    @Override
    public String updateUserAndRollback(Long id, String userName) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setName(userName);

        userRepository.save(existingUser);

        return "Rollback a user id " + id + " update transaction";
    }
}
