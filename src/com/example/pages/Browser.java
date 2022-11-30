package com.example.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Browser {
    public WebDriver driver;
    Date d= new Date();
    String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //@AfterTest
    public void close() {
        driver.close();
    }

    @AfterMethod
    public void failScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("Failed Test is : "+result.getName());
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("D:\\Test_Practice\\Screenshots\\"+ TimeStamp +".png"));
            //FileUtils.copyFile(file, new File("./Screenshots/"+ "_" + TimeStamp + ".png"));
        }
    }
}
