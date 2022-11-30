package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Extending {
    WebDriver driver;
    String city = "Dondapudi";
    @FindBy(xpath = "(//div[@class='searchContainer']/div/div/input)[1]")
    WebElement location;
    @FindBy(xpath = "(//div[@class='searchContainer']/div/div/input)[2]")
    WebElement serachFood;
    @FindBy(xpath = "//div[@class='sc-bSbAYC freBkn'][1]")
    WebElement delivery;
    @FindBy(xpath = "//div[@class='sc-bSbAYC freBkn'][2]")
    WebElement dineIn;
    @FindBy(xpath = "//h1[contains(.,'Biryani Delivery Restaurants')]")
    WebElement textverify;


    public Extending(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFood(WebDriver driver) throws Exception {

        location.click();
        location.sendKeys(city);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-iLVFha ccmMCl']")));

        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='sc-iLVFha ccmMCl']"));
        for (WebElement list : ele) {
            if (list.getText().contains(city)) {
                list.click();
            }
        }
        serachFood.click();
        serachFood.sendKeys("biryani");
        delivery.click();
        Assert.assertEquals("Biryani Delivery Restaurants in Dondapudi, Eluru, India", textverify.getText());

    }
}
