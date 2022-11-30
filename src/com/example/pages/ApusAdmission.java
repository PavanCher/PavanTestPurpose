package com.example.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ApusAdmission {
    WebDriver driver;
    Faker faker = new Faker(new Locale("en-US"));

    public ApusAdmission(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//a[text()='Apply Now'])[1]")
    WebElement applybutton;

    @FindBy(xpath = "//input[@name='FormModel.FirstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='FormModel.LastName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Create Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Create Password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='FormModel_ChallengeQuestionId']")
    WebElement securityQuestion;

    @FindBy(xpath = "//input[@placeholder='Answer']")
    WebElement answer;

    @FindBy(xpath = "//input[@name='FormModel.PhoneNumber']")
    WebElement phone;

    @FindBy(xpath = "//input[@name='FormModel.ZipCode']")
    WebElement zipcode;

    @FindBy(xpath = "//div[@class='selectize-control single']/div/input")
    WebElement citizenship;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement continueButton;

    @FindBy(xpath = "//select[@class='labeled-input']")
    WebElement previousEducation;


    public void admission(WebDriver driver) throws InterruptedException {
        applybutton.click();
        Set<String> window = driver.getWindowHandles();//[parent id, child id]
        Iterator<String> it = window.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-bar']")));
        String fname = faker.name().lastName();
        firstname.sendKeys(fname);
        lastname.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        username.sendKeys(fname);
        password.sendKeys(fname + "1234$");
        System.out.println("Password Entered is :" + password.getAttribute("value"));
        Thread.sleep(2000);
        Select s = new Select(securityQuestion);
        //selecting the random values from dropdown
        List<WebElement> options = s.getOptions();
        /*int size = options.size();
        Random num = new Random();
        int iSelect = num.nextInt(size);
        s.selectByIndex(iSelect);*/

        for (WebElement opts : options) {
            if (opts.getText().contains("What is the name of your favorite childhood friend?")) {
                opts.click();
                break;
            }
        }
        answer.sendKeys("abcxyz");
        phone.sendKeys(faker.phoneNumber().cellPhone());
        zipcode.sendKeys("25414");
        /*Actions act=new Actions(driver);
        act.moveToElement(citizenship).click().build().perform();*/
        citizenship.sendKeys("uni", Keys.ENTER);
        Thread.sleep(2000);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();",citizenship);

        /*List<WebElement> states = driver.findElements(By.xpath("//div[@class='option']"));
        for (WebElement element : states) {
            //System.out.println(element.getText());
            if (element.getText().contains("United Kingdom")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                //element.click();
                Thread.sleep(2000);
                break;
            }
        }
*/
        //continueButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Previous')]")));

        try {
            System.out.println("Text is = " + driver.findElement(By.xpath("//h2[contains(.,'Previous')]")).getText());
            wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@class='labeled-input']"))));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", previousEducation);
            List<WebElement> program = driver.findElements(By.xpath("//select[@class='labeled-input']/optgroup/option"));
            for (WebElement element : program) {
                if (element.getText().contains("Bachelor's Degree")) {
                    element.click();
                    Thread.sleep(2000);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception is:= " + e);
        }
    }
}

