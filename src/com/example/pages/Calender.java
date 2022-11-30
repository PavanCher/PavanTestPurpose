package com.example.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //WebElement scroll= driver.findElement(By.xpath("//span[@class='flatpickr-day ']"));
        Faker faker = new Faker();
        String date = String.valueOf(faker.random().nextInt(31));

        WebElement element = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        element.click();

        while (!(driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("March"))) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }
        Thread.sleep(3000);
        List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
        for (WebElement dateOpt : dates) {

            if (dateOpt.getText().contains(date)) {
                dateOpt.click();
                break;
            }

        }

    }
}
