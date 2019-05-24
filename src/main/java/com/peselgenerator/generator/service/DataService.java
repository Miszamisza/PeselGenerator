package com.peselgenerator.generator.service;

import org.springframework.stereotype.Service;

@Service
public interface DataService {

    public int[] peselGenerator (int dayOfBirth, int monthOfBirth, int yearOfBirth, String sex);
    public String peselCheck(int[] pesel);
}
