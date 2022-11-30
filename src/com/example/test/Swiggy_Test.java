package com.example.test;

import com.example.pages.ApusAdmission;
import com.example.pages.Browser;
import com.example.pages.Swiggy;
import org.testng.annotations.Test;



public class Swiggy_Test extends Browser {

    @Test
    public void swiggyOrder() throws InterruptedException {

        driver.get("https://www.swiggy.com/");
        Swiggy s = new Swiggy(driver);
        s.search(driver);
    }
    @Test
    public void Apustest() throws InterruptedException {
        driver.get("https://www.apu.apus.edu/");
        ApusAdmission apus=new ApusAdmission(driver);
        apus.admission(driver);
    }
}
