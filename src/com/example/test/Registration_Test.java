package com.example.test;

import com.example.pages.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Registration_Test {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "D://Test_Practice//Drivers//msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://my.bethematch.org/s/?language=en_US");
        Registration reg=new Registration();
        reg.register(driver);
        Thread.sleep(5000);
        reg.createAccount(driver);
        reg.mail(driver);
    }
}
