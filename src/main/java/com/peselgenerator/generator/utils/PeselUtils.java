package com.peselgenerator.generator.utils;

import com.peselgenerator.generator.entity.UserDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Component
public class PeselUtils {

    private final UserDataGenerator userDataGenerator;

    @Autowired
    public PeselUtils(UserDataGenerator userDataGenerator) {
        this.userDataGenerator = userDataGenerator;
    }


    public int peselChooseCorrectYear(@RequestParam int yearOfBirth,
                                      @RequestParam int monthOfBirth) {
        if (yearOfBirth >= 1800 && yearOfBirth <= 1899) {
            return monthOfBirth=(monthOfBirth / 10 + 80);
        }

        if (yearOfBirth >= 1900 && yearOfBirth <= 1999) {
            return monthOfBirth=(monthOfBirth);
        }

        if (yearOfBirth >= 2000 && yearOfBirth<= 2099) {
            return monthOfBirth=(monthOfBirth / 10 + 20);
        }

        if (yearOfBirth >= 2100 && yearOfBirth <= 2199) {
            return monthOfBirth=(monthOfBirth / 10 + 40);
        }
        if (yearOfBirth >= 2200 && yearOfBirth <= 2299) {
            return monthOfBirth=(monthOfBirth / 10 + 60);
        } else {
            throw new IllegalArgumentException("Year of birth is incorrect");
        }
    }

    public int chooseSex(String sex) {
        int[] tabHelpPeselBoy = {1, 3, 5, 7, 9};
        int[] tabHelpPeselGirl = {0, 2, 4, 6, 8};
        Random rand = new Random();
        int sexNumber;
        if (sex.equals("Men")) {
            int i = rand.nextInt (3) + 1;
            return sexNumber = tabHelpPeselBoy[i];
        }
        if (sex.equals ("Women") || sex.equals("K")) {
            int j = rand.nextInt (3) + 1;
            return sexNumber = tabHelpPeselGirl[j];
        } else
            throw new IllegalArgumentException ("Incorrect sex");

    }
}
