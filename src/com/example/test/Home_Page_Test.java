package com.example.test;

import com.example.pages.Home_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

class Home_Page_Test {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/");
        Home_Page page = new Home_Page(driver);
        page.landToHome(driver);
        page.homePageLinks(driver);
        driver.close();

    }

}