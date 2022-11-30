package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        //method 1
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ESCAPE).perform();
        //method 2
        /*WebElement element= driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        element.sendKeys(Keys.ESCAPE);*/
        //method 3
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
        WebElement serch=driver.findElement(By.xpath("//input[@class='_3704LK']"));
        serch.sendKeys("mobiles", Keys.ENTER);
    }
}
