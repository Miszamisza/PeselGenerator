package com.peselgenerator.generator.service;

public class DataServiceImpl implements DataService {
    @Override
    public int[] peselGenerator(int dayOfBirth, int monthOfBirth, int yearOfBirth, String sex) {


        return new int[0];
    }

    @Override
    public String peselCheck(int[] pesel) {

        return "Pesel is incorrect";
    }
}
