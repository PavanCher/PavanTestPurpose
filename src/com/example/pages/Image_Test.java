package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Image_Test {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "D://Test_Practice//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String urls = "https://www.facebook.com/";
        driver.get(urls);
        //identify image
        /*WebElement i = driver.findElement(By.xpath("//img[@class='light-mode-item navbar-brand-item']"));
        // Javascript executor to check image
        Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
                + "&& typeof arguments[0].naturalWidth != \"undefined\" "
                + "&& arguments[0].naturalWidth > 0", i);

        //verify if status is true
        if (p) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
        driver.quit();*/

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + links.size());

        //We will iterate through the list and will check the elements in the list.

        for(int i=0;i<links.size();i++)
        {
            System.out.println(links.get(i).getAttribute("href"));
            verifyLinks(links.get(i).getAttribute("href"));

        }
        /*for (WebElement href : links) {
            String uri = href.getAttribute("href");
            System.out.println(uri);
            verifyLinks(uri);
        }*/

    }

    public static void verifyLinks(String linkUrl) throws IOException {

        URL url = new URL(linkUrl);

        //Now we will be creating url connection and getting the response code
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(5000);
        con.connect();
        if (con.getResponseCode() >= 400) {
            System.out.println("HTTP STATUS - " + con.getResponseMessage() + ": is a broken link");
        }

        //Fetching and Printing the response code obtained
        else {
            System.out.println("HTTP STATUS - " + con.getResponseMessage());
        }

    }
}

