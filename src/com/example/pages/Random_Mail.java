package com.example.pages;

import java.util.Random;

public class Random_Mail {

    public String randomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String emailid = "pavanch" + "+" + randomInt + "@gmail.com";
        return emailid;
    }
}
