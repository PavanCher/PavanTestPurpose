package com.example.test;

import com.example.pages.Window;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Window_Test {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://my.bethematch.org/s/?language=en_US");

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("D:\\Test_Practice\\Screenshots\\screenshot.png"));

        Window w= new Window();
        w.facebookShare(driver);
        Thread.sleep(5000);
        //w.twitterShare(driver);

        driver.close();
    }
}