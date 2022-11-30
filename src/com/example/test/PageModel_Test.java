package com.example.test;

import com.example.pages.PageModel;
import com.example.pages.Window;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class PageModel_Test implements ITestListener {

    WebDriver driver;
    Date d= new Date();
    String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");

    /*@BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }*/
//@Parameters({"URL"})
    @Test
    public void register() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        PageModel page = new PageModel(driver);
        page.signupPage(driver);

    }

    //@Test
    public void shareToFb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://my.bethematch.org/s/?language=en_US");
        Window w = new Window();
        w.facebookShare(driver);
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


