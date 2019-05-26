package com.peselgenerator.generator.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@Data
public class UserDataCheck {

    private Long pesel;
}
