package com.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Home_Page {
    WebDriver driver;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    WebElement googleSearch;

    @FindBy(xpath = "//div[@class='CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb']/span")
    WebElement amazonLink;

    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void landToHome(WebDriver driver) throws InterruptedException, Exception {

        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        googleSearch.sendKeys("amazon", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb']/span")));
        amazonLink.click();
        String amazonTitle = driver.findElement(By.xpath("//div[@id='nav-logo']")).getText();
        String pageTitle = driver.getTitle();
        //System.out.println(pageTitle);
        String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(pageTitle, expTitle, "not matched");

    }

    public void homePageLinks(WebDriver driver) throws InterruptedException {

        //driver.navigate().refresh();
        //driver.findElement(By.linkText("Sell")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='zg_banner_text']")));
        //Thread.sleep(2000);
        //Assert.assertEquals("Sell on Amazon", driver.findElement(By.xpath("//div[@class='has-max-width']/h2")).getText());
        driver.findElement(By.linkText("Best Sellers")).click();
        Assert.assertEquals("Amazon Bestsellers", driver.findElement(By.xpath("//span[@id='zg_banner_text']")).getText());
        driver.findElement(By.linkText("Mobiles")).click();
        Assert.assertEquals("Mobiles & Accessories", driver.findElement(By.xpath("//div[@id='nav-subnav']/a[2]")).getText());
        driver.findElement(By.linkText("Customer Service")).click();
        Assert.assertEquals("Hello. What can we help you with?", driver.findElement(By.xpath("//h1[contains(text(),'Hello. What can we help')]")).getText());
        driver.findElement(By.linkText("Electronics")).click();
        Assert.assertEquals("Mobiles & Accessories", driver.findElement(By.xpath("//div[@id='nav-subnav']/a[2]")).getText());
        driver.findElement(By.linkText("Books")).click();
        Assert.assertEquals("Books", driver.findElement(By.xpath("//div[@id='nav-subnav']/a[1]/span")).getText());
        driver.findElement(By.linkText("Fashion")).click();
        boolean img = driver.findElement(By.xpath("//div[@id='nav-subnav']/a[1]/span/img")).isDisplayed();
        System.out.println("Amazon Fashion image is displayed=" + img);
        driver.findElement(By.linkText("Home & Kitchen")).click();
        boolean img2 = driver.findElement(By.xpath("//div[@id='nav-subnav']/a[1]/span/img")).isDisplayed();
        System.out.println("Amazon Home image is displayed=" + img);
        Assert.assertEquals("Kitchen & Home Appliances", driver.findElement(By.xpath("//div[@id='nav-subnav']/a[2]/span[1]")).getText());

    }


}

