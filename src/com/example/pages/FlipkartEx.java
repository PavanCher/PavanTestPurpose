package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartEx {

    WebDriver driver;

    public void FlipkartEx(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /*@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
    WebElement input;*/
    /*@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
    WebElement cancel;*/
    @FindBy(xpath = "//input[@class='_3704LK']")
    WebElement searchbar;
    @FindBy(xpath = "//div[text()='APPLE']")
    WebElement appleItem;
    @FindBy(xpath = "//div[@class='_24_Dny _3tCU7L']")
    WebElement flipkartAssured;


    public void Search(WebDriver driver) throws InterruptedException {

        Actions act = new Actions(driver);
        act.sendKeys(Keys.ESCAPE).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='go_DOp']/a/span")));
        searchbar.click();
        searchbar.sendKeys("mobiles", Keys.ENTER);
        appleItem.click();
        flipkartAssured.click();
    }
}
