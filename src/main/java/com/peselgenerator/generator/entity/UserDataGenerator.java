package com.peselgenerator.generator.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Component
@NotNull
@Data
public class UserDataGenerator {

    @NotEmpty
    private int dayOfBirth;
    @NotEmpty
    private int monthOfBirth;
    @NotEmpty
    private int yearOfBirth;
    @NotEmpty
    private String sex;

    private int number1;
    private int number2;
    private int number3;
}
