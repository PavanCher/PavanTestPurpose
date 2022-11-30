package com.example.pages;


import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Registration {
    WebDriver driver;

    public void register(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'JOIN THE DONOR REGISTRY')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Between 18 and 40')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'None of the above')]")).click();
        driver.findElement(By.xpath("(//button[contains(text(),'Next')])[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("pavan");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kumar");
        driver.findElement(By.xpath("//input[@name='month']")).sendKeys("09");
        driver.findElement(By.xpath("//input[@name='day']")).sendKeys("09");
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("1999");

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        String emailid="pcherukuri"+"+"+ randomInt + "@teksystems.com";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailid);

        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pavanch22@gmail.com");
        driver.findElement(By.xpath("//input[@name='cellphone']")).sendKeys("2012457895");
        driver.findElement(By.xpath("//div[@class='slds-p-top_none']//div//input[@class='slds-input']")).sendKeys("G Admiralty Dr W Apt 1");

        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Middletown");

        driver.findElement(By.xpath("//button[@name='state']")).click();
        List<WebElement> states = driver.findElements(By.xpath("//label[text()='State']/..//lightning-base-combobox-item/span/span"));

        for (WebElement element : states) {
            if (element.getText().contains("Rhode Island")) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
            }
        }
        driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("02842");
        driver.findElement(By.xpath("//span[text()='Male']/../span[1]")).click();
        driver.findElement(By.xpath("//button[@name='Feet']")).click();
        List<WebElement> feetopt = driver.findElements(By.xpath("//label[text()='Feet']/..//lightning-base-combobox-item/span/span"));
        for (WebElement feet : feetopt) {
            if (feet.getText().contains("6")) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feet);
                feet.click();
            }
        }

        driver.findElement(By.xpath("//button[@name='Inches']")).click();
        List<WebElement> inchopt = driver.findElements(By.xpath("//label[text()='Inches']/..//lightning-base-combobox-item/span/span"));
        for (WebElement inch : inchopt) {
            if (inch.getText().contains("3")) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inch);
                Thread.sleep(2000);
                inch.click();
            }
        }
        

        driver.findElement(By.xpath("//input[@name='Weight']")).sendKeys("110");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='White']")).click();
        driver.findElement(By.xpath("//span[text()='Southern European']")).click();
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'I have read and understand')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("pavan");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        WebElement swab = driver.findElement(By.xpath("//span[text()='I need a swab kit shipped to me']"));
        if (!swab.isSelected()) {
            swab.click();
        }
        driver.findElement(By.xpath("//button[text()='SUBMIT REGISTRATION']")).click();
    }

    public void createAccount(WebDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pavan515$");
        //driver.findElement(By.xpath("//input[@name='passwordVerify']")).sendKeys("Pavan515$");
        //driver.findElement(By.xpath("//button[@name='question']")).click();
        //driver.findElement(By.xpath("//button[@name='question']")).sendKeys(Keys.DOWN,Keys.ENTER);
        //driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("test");
        WebElement twostepverf=driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));

        if (!twostepverf.isSelected())
        {
            twostepverf.click();
        }

        WebElement careButton = driver.findElement(By.xpath("//span[text()='No']"));
        if (!careButton.isSelected()) {
            careButton.click();
        }
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

    }
    public void mail(WebDriver driver) throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://outlook.office365.com/mail/");
        driver.findElement(By.xpath("//div[@class='C2IG3 LPIso oTkSL iDEcr wk4Sg']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='My Be The Match']")).click();
        String verification=driver.findElement(By.xpath("//span[@style='font-size:36px; line-height:50.4px']")).getText();

        Set<String> window = driver.getWindowHandles();//[parent id, child id]
        Iterator<String> it = window.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(parentid);

        driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(verification);
        driver.findElement(By.xpath("//button[text()='VERIFY CODE']")).click();

    }
}



