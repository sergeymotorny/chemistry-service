package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.UserDto;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUser(long id);
    UserDto createUser(UserDto userDto);
    String deleteUser(long id);
    UserDto updateUser(UserDto userDto, long id);
    String updateUserAndRollback(Long id, String userName);
}
