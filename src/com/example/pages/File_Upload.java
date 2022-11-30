package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class File_Upload {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.monsterindia.com/");
        driver.findElement(By.xpath("//span[text()='Upload Resume']")).click();
        //method 1 Using sendKeys
        //driver.findElement(By.xpath("(//input[@id='file-upload'])[1]")).sendKeys("C://Users//pcherukuri//Downloads//Diwali Gift - 2022.pdf");
        //((JavascriptExecutor)driver).executeScript("arguments[0].Click());",button);
        WebElement ele=driver.findElement(By.xpath("//input[@id='file-upload']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);

        ////method 2 Using Robot Class(AWT)
        Robot rb=new Robot();
        rb.delay(2000);
        StringSelection ss=new StringSelection("C:\\Users\\pcherukuri\\Downloads\\Diwali Gift - 2022.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@class='toasterContent']")).getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='pop_upload']")).click();


    }
}
