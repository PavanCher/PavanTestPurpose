package com.example.pages;

import java.util.Random;

public class Random_String {

    public static String generateRandomName(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();

    }

    public static void main(String[] args) {

        String text = generateRandomName(8);
        System.out.println(text);

    }
}
