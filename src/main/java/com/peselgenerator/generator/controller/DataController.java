package com.peselgenerator.generator.controller;

import com.peselgenerator.generator.entity.UserDataCheck;
import com.peselgenerator.generator.entity.UserDataGenerator;
import com.peselgenerator.generator.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    private DataService dataService;

    @Autowired
    DataController(DataService dataService){
        this.dataService = dataService;
    }

    @PostMapping("/pesel_generate")
    public int[] peselGenerator(int dayOfBirth, int monthOfBirth, int yearOfBirth, String sex){
        return dataService.peselGenerator(dayOfBirth, monthOfBirth, yearOfBirth, sex);
    }

    @GetMapping("/pesel_check")
    public String peselCheck(@RequestBody UserDataCheck userDataCheck){
        return dataService.peselCheck(userDataCheck.getPesel());
    }

}
