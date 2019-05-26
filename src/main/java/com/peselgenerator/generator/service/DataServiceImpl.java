package com.peselgenerator.generator.service;

import com.peselgenerator.generator.entity.UserDataCheck;
import com.peselgenerator.generator.entity.UserDataGenerator;
import com.peselgenerator.generator.utils.PeselUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

@Service
public class DataServiceImpl implements DataService {

    private UserDataGenerator userDataGenerator;
    private Random rand = new Random();
    private int sexNumber;
    private int controlNumber;

    @Autowired
    private PeselUtils peselUtils;

    @Autowired
    private DataServiceImpl(UserDataGenerator userDataGenerator) {
        this.userDataGenerator = userDataGenerator;
    }

    @Autowired
    private UserDataCheck userDataCheck;


    @Override
    public String peselGenerator(int dayOfBirth, int monthOfBirth, int yearOfBirth, String sex) {
        int monthOfBirth1 = peselUtils.peselChooseCorrectYear(yearOfBirth, monthOfBirth);
        userDataGenerator.setNumber1(rand.nextInt(9) + 1);
        userDataGenerator.setNumber2(rand.nextInt(9) + 1);
        userDataGenerator.setNumber3(rand.nextInt(9) + 1);
        userDataGenerator.setDayOfBirth(dayOfBirth);
        userDataGenerator.setMonthOfBirth(monthOfBirth);
        userDataGenerator.setYearOfBirth(yearOfBirth);

        sexNumber = peselUtils.chooseSex(sex);
        userDataGenerator.setDayOfBirth(sexNumber);

        controlNumber = ((yearOfBirth % 1000 % 100 % 10) * 9 +
                (yearOfBirth - yearOfBirth % 1000 % 100 % 10) * 7 + (monthOfBirth1 % 10) * 3 +
                (monthOfBirth1 - monthOfBirth1 % 10) + (dayOfBirth % 10) * 9 +
                (dayOfBirth - dayOfBirth % 10) * 7 +
                3 * userDataGenerator.getNumber1() +
                userDataGenerator.getNumber2() +
                9 * userDataGenerator.getNumber3() +
                7 * sexNumber) % 100 % 10;

        int[] pesel = new int[]{yearOfBirth % 1000 % 100, monthOfBirth1, dayOfBirth, userDataGenerator.getNumber1(), userDataGenerator.getNumber2(),
                userDataGenerator.getNumber3(), sexNumber, controlNumber};

        return pesel.toString();
    }

    @Override
    public String peselCheck(Long pesel) {
        userDataCheck.setPesel(pesel);
        int [] pesel1 = Long.toString(pesel).chars().map(c -> c-'0').toArray();
        if (((pesel1[0] * 9 +
                        pesel1[1] * 7 +
                        pesel1[2]* 3 +
                        pesel1[3]+
                        pesel1[4] * 9 +
                        pesel1[5]* 7 +
                        pesel1[6] * 3 +
                        pesel1[7] +
                        pesel1[8] * 9 +
                        pesel1[9]) % 100 % 10) == pesel1[10]) {
            return "Pesel is correct";

        } else
            return "Pesel is not correct";

    }
}
