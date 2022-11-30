package com.example.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SignUp {

    public void signupPage(WebDriver driver) throws Exception {

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("testing");
        driver.findElement(By.id("LastName")).sendKeys("purpose");
        Select date = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        //System.out.println(option.getOptions());
        date.selectByValue("3");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByIndex(6);
        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText("1993");
        System.out.println(year.getFirstSelectedOption().getText());

        List<WebElement> values = date.getOptions();
        //get the values from dropdown : method 1
        for (WebElement dateValues : values) {
            System.out.println(dateValues.getText());
        }
        List<WebElement> monthValues = month.getOptions();
        //get the values from dropdown : method 2
        for (int i = 1; i < monthValues.size(); i++) {
            System.out.println(monthValues.get(i).getText());
        }

        Random_Mail mail = new Random_Mail();
        String mailid = mail.randomEmail();
        System.out.println("Mail id =" + mailid);

        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(mailid);
        driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("ABC Groups.inc");
        WebElement newsLetter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        if (newsLetter.isSelected()) {
            newsLetter.click();
        }
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Abc12345");
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Abc12345");
        driver.findElement(By.xpath("//button[@name='register-button']")).click();
        WebElement succusMsg = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Your registration completed", succusMsg.getText());
        System.out.println(succusMsg.getText());
        driver.findElement(By.xpath("//div[@class='buttons']/a")).click();
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Thread.sleep(3000);


        WebElement element = driver.findElement(By.xpath("//input[@name='Email']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        //capturing the entred text from text box
        WebElement textcap=driver.findElement(By.xpath("//input[@id='Email']"));
        String val=textcap.getAttribute("value");
        System.out.println("Entered text is: " + val);
        Assert.assertEquals(val,mailid);
        System.out.println(driver.findElement(By.xpath("//a[@class='ico-wishlist']")).getAttribute("href"));

    }
}

