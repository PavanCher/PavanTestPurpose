package com.example.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

public class PageModel {
    WebDriver driver;

    public PageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Locale local=new Locale("en-IND");
    Faker faker = new Faker(local);

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement RegisterLink;

    @FindBy(id = "gender-male")
    WebElement Gender;

    @FindBy(id = "FirstName")
    WebElement FirstName;

    @FindBy(id = "LastName")
    WebElement LastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement day;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement month;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement year;

    @FindBy(xpath = "//input[@name='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='Company']")
    WebElement company;

    @FindBy(xpath = "//input[@id='Newsletter']")
    WebElement newsletter;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='ConfirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@name='register-button']")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement registerSuccessMsg;

    @FindBy(xpath = "//div[@class='buttons']/a")
    WebElement continueButton;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement accountLink;

    public void signupPage(WebDriver driver) throws Exception {

        RegisterLink.click();
        Gender.click();
        FirstName.sendKeys(faker.name().firstName());
        LastName.sendKeys(faker.name().lastName());
        selectOptions(day, "3");
        selectOptions(month, "April");
        selectOptions(year, "1993");

        Select dayValues = new Select(day);
        List<WebElement> values = dayValues.getOptions();
        //get the values from dropdown
        for (WebElement dateValues : values) {
            System.out.println(dateValues.getText());
        }

       /* Random_Mail mail = new Random_Mail();
        String mailid = mail.randomEmail();
        System.out.println("Mail id =" + mailid);*/

        email.sendKeys(faker.internet().emailAddress());
        company.sendKeys(faker.company().name());

        if (newsletter.isSelected()) {
            newsletter.click();
        }
        String passwod=faker.random().hex(9);
        password.sendKeys(passwod);
        confirmPassword.sendKeys(passwod);
        registerButton.click();

        Thread.sleep(3000);
        Assert.assertEquals("Your registration completed", registerSuccessMsg.getText());
        //Assert.assertEquals("completed", registerSuccessMsg.getText());
        System.out.println(registerSuccessMsg.getText());
        continueButton.click();
        accountLink.click();

    }

    public static void selectOptions(WebElement ele, String value) {
        Select drop = new Select(ele);
        List<WebElement> allOptions = drop.getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().equalsIgnoreCase(value)) {
                options.click();
                break;
            }

        }
    }
}
