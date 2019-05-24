package com.peselgenerator.generator.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDataCheck {

    @NotEmpty
    private int[] pesel;
}
