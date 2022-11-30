package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Swiggy {
    WebDriver driver;

    public Swiggy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String city = "Hyderabad";
    String restauratName = "Mughal Restaurant";
    String lists[] = {"Tomato Curry", "Mushroom Masala"};
    @FindBy(xpath = "//input[@id='location']")
    WebElement location;

    @FindBy(xpath = "(//div[@class='_3e_kl']/a)[3]/img")
    WebElement bestInTown;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchicon;

    @FindBy(xpath = "//input[@class='_2FkHZ']")
    WebElement searchresturantName;

    @FindBy(xpath = "//div[text()='Mughal Restaurant']")
    WebElement resturantName;

    @FindBy(xpath = "//div[text()='ADD']")
    List<WebElement> add;

    @FindBy(xpath = "//button[@class='_1gPB7']")
    WebElement checkout;

    @FindBy(xpath = "//div[@class='_161V3']/div/span")
    WebElement checkamount;

    @FindBy(xpath = "//div[@class='_3ZAW1']")
    WebElement topay;

    /*@FindBy(xpath = "//div[@class='_3QkCH']")
    WebElement discount;*/

    @FindBy(xpath = "//div[@class='_1oLDb']/button")
    WebElement serached;

    public void search(WebDriver driver) throws InterruptedException {
        location.click();
        location.sendKeys(city);
        Thread.sleep(2000);

        if (serached.getText().contains("Hyderabad, Telangana, India")) {
            serached.click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_3e_kl']/a)[3]/img")));
        bestInTown.click();
        searchicon.click();
        searchresturantName.sendKeys(restauratName, Keys.ENTER);
        resturantName.click();
        Thread.sleep(4000);

        for (int j = 0; j < lists.length; j++) {
            List<WebElement> items = driver.findElements(By.xpath("//div[@class='_2wg_t']/../div"));
            for (int i = 0; i < items.size(); i++) {
                String name = items.get(i).getText();
                if (name.contains(lists[j])) {
                    add.get(i).click();
                }
            }
        }

        Thread.sleep(3000);
        System.out.println("Total Amount=" + checkamount.getText());
        checkout.click();
        System.out.println("After discount - Amount to pay =" + topay.getText());
        //System.out.println("discount applied =" + discount.getText());

    }
}

