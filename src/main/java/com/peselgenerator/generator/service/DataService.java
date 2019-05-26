package com.peselgenerator.generator.service;

public interface DataService {

    String peselGenerator (int dayOfBirth, int monthOfBirth, int yearOfBirth, String sex);
    String peselCheck(Long pesel);
}
