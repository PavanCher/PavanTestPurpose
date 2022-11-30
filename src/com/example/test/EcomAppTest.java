package com.example.test;

import com.example.pages.Browser;
import com.example.pages.EcomApp;
import org.testng.annotations.Test;

public class EcomAppTest extends Browser {
    @Test
    public void orederItem() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com");
        EcomApp app=new EcomApp(driver);
        app.orderItem(driver);
    }
}
