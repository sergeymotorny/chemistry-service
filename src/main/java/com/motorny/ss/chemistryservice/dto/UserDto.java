package com.motorny.ss.chemistryservice.dto;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private Set<ReviewDto> reviews = new LinkedHashSet<>();
}
