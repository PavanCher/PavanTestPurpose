package com.example.test;

import com.example.pages.InterfaceDemo;
import org.testng.annotations.Test;

public class InterfaceTest implements InterfaceDemo {
    @Override
    public void redSignal() {
        System.out.println("Stop the all vehicles");
    }

    @Override
    public void yellowSignal() {
        System.out.println("Ready to go all vehicles");
    }

    @Override
    public void greenSignal() {
        System.out.println("Proceed the vehicles");
    }
    @Test
    public void signalImplementation(){
        InterfaceTest t=new InterfaceTest();
        t.redSignal();
        t.greenSignal();
        t.yellowSignal();
    }
}
