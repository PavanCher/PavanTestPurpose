package com.example.pages;

public class Dummy {
     private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println(speed);
    }

    public void start(){
        System.out.println("Bike started");
    }
}
