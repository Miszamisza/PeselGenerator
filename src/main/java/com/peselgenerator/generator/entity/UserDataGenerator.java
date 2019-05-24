package com.peselgenerator.generator.entity;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NotNull
public class UserDataGenerator {

    @NotEmpty
private int dayOfBirth;
    @NotEmpty
private int monthOfBirth;
    @NotEmpty
private int yearOfBirth;
    @NotEmpty
private String sex;


}
