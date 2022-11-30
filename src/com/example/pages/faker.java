package com.example.pages;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class faker {
    public static void main(String[] args) {
        //method 1
        /*Locale local=new Locale("en-IND");
        Faker faker = new Faker(local);*/
        //method 2
        Faker faker = new Faker(new Locale("en-IND"));

        System.out.println(faker.company().name());
        System.out.println(faker.random().hex(9));
        System.out.println(faker.number().digits(8));
        System.out.println(faker.address().state());
        System.out.println(faker.name().firstName());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.name().lastName());
        System.out.println(faker.number().numberBetween(1,30));
        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.random().nextInt(31));

        System.out.println(faker.date().birthday());

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        String dob = sdf.format(faker.date().birthday());
        System.out.println(dob);

    }
}
