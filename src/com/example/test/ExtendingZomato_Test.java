package com.example.test;

import com.example.pages.Browser;
import com.example.pages.Extending;
import com.example.pages.FlipkartEx;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class ExtendingZomato_Test extends Browser {

    @Test
    public void zomatoSearch() throws Exception {

        driver.get("https://www.zomato.com/");
        Extending ext = new Extending(driver);
        ext.searchFood(driver);
    }

    //@Test(timeOut = 40000)
    public void flipkartSearch() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        FlipkartEx flip = new FlipkartEx();
        flip.Search(driver);

    }
}
