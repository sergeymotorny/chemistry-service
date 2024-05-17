package com.motorny.ss.chemistryservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDto {

    private long id;
    private String name;
    private String country;
    private int yearFounded;
}
