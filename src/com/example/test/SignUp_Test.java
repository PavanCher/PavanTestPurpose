package com.example.test;

import com.example.pages.Browser;
import com.example.pages.SignUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUp_Test extends Browser {
    SignUp up = new SignUp();
    @Test
    public void signUp() throws Exception {
        driver.get("https://demo.nopcommerce.com/");
        up.signupPage(driver);
        Thread.sleep(3000);
        //driver.close();

    }
}
