package com.example.test;

import com.example.pages.Dummy;
import org.testng.annotations.Test;

public class DummyTest {
    @Test
    public void call(){
        Dummy d=new Dummy();
        d.start();
        d.setSpeed(100);

    }
}
