package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.UserDto;
import com.motorny.ss.chemistryservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "reviews", target = "reviews")
    UserDto toUserDto(User user);

    @Mapping(source = "reviews", target = "reviews")
    User toUser(UserDto userDto);
}
