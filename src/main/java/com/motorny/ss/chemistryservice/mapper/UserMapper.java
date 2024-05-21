package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.UserDto;
import com.motorny.ss.chemistryservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReviewMapper.class)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
