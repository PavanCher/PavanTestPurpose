package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Window {
    WebDriver driver;

    public void facebookShare(WebDriver driver) throws InterruptedException {

        //sharing the artcle to the facebook
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(.,'Get involved')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Explore stories')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Stories')]")));
        //System.out.println(driver.findElement(By.xpath("//span[contains(.,'Stories')]")).getText());
        Assert.assertEquals("STORIES", driver.findElement(By.xpath("//span[contains(.,'Stories')]")).getText());
        driver.findElement(By.xpath("//a[contains(.,'Wishes to give back from')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x7s-social-share__facebook']")));
        driver.findElement(By.xpath("//li[@class='x7s-social-share__facebook']")).click();

        Set<String> window = driver.getWindowHandles();//[parent id, child id]
        Iterator<String> it = window.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);

        driver.findElement(By.id("email")).sendKeys("pavan515");
        driver.findElement(By.id("pass")).sendKeys("7013518535");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='u_0_25_3Y']")));

        driver.findElement(By.xpath("//button[@type='submit'][2]")).click();

        //opening the new tab within the same opened browser
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//div[@class='x78zum5 x1nhvcw1 x1n2onr6 xh8yej3']/a)[2]")).click();
        //scroll down method
        WebElement element = driver.findElement(By.xpath("//span[contains(.,'Wishes to give back from')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        String title = driver.findElement(By.xpath("//span[text()='Wishes to give back from a transplant recipient']/../span")).getText();
        System.out.println("title=" + title);
        driver.close();
        driver.switchTo().window(parentid);


    }

    public void twitterShare(WebDriver driver) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Splitting the string
        /*System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Choose a path to join our community')]")).getText());
        String text=driver.findElement(By.xpath("//div[contains(text(),'Choose a path to join our community')]")).getText().split(",")[1].split("or")[1];
        System.out.println("Separated text ="+text);*/

        //sharing the artcile to twitter
        driver.findElement(By.xpath("//span[contains(.,'Get involved')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Explore stories')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Stories')]")));
        //System.out.println(driver.findElement(By.xpath("//span[contains(.,'Stories')]")).getText());
        Assert.assertEquals("STORIES", driver.findElement(By.xpath("//span[contains(.,'Stories')]")).getText());
        driver.findElement(By.xpath("//a[contains(.,'Wishes to give back from')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x7s-social-share__twitter']")));
        driver.findElement(By.xpath("//li[@class='x7s-social-share__twitter']")).click();

        Thread.sleep(5000);
        //Handling the Child window
        Set<String> window = driver.getWindowHandles();//[parent id, child id]
        Iterator<String> it = window.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);

        driver.findElement(By.xpath("//input[@name='session[username_or_email]']")).sendKeys("@pavanch8");
        driver.findElement(By.xpath("//input[@name='session[password]']")).sendKeys("7013518535");
        driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[contains(.,'Tweet')]/span)[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-1dbjc4n'])[6]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n'])[6]")).click();

        WebElement element = driver.findElement(By.xpath("//div[@class='css-1dbjc4n']/div/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(2000);
        String linkText = driver.findElement(By.xpath("//div[@class='css-1dbjc4n']/div/a")).getText();
        System.out.println("text=" + linkText);
        driver.close();

    }
}
