package com.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class EcomApp {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginbutton;

    @FindBy(xpath = "//input[@class='email']") //planittest78@gmail.com
    WebElement username;

    @FindBy(xpath = "//input[@class='password']") //123456
    WebElement password;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement login;

    @FindBy(xpath = "(//div[@class='header-links']/ul/li/a)[1]")
    WebElement userid;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    WebElement shoppingCartlink;

    @FindBy(xpath = "//input[@type='checkbox' and @name='removefromcart']")
    WebElement removecheckbox;

    @FindBy(xpath = "//input[@class='button-2 update-cart-button']")
    WebElement updateCart;

    @FindBy(xpath = "//div[@class='order-summary-content']")//need to verify
    WebElement emptycartmsg;

    @FindBy(xpath = "(//div[@class='header-menu']/ul/li)[2]/a")//mouse over
    WebElement computersSection;

    @FindBy(xpath = "//body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
    WebElement desktop;

    @FindBy(xpath = "//h2[contains(.,'Build your own cheap computer')]")
    WebElement computerlist;

    @FindBy(xpath = "//div[@class='product-price']")
    WebElement computerPrice;

    @FindBy(xpath = "//input[@class='qty-input']")
    WebElement quantity;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    WebElement addtocart;

    @FindBy(xpath = "(//div[@class='header-menu']/ul/li)[1]/a")
    WebElement books;

    @FindBy(xpath = "//a[text()='Computing and Internet']")
    WebElement bookitem;

    @FindBy(xpath = "//span[@class='cart-qty']")
    WebElement cardqunty;

    @FindBy(xpath = "//div[@class='bar-notification success']/p")
    WebElement successsMsg;

    @FindBy(xpath = "//div[@class='bar-notification success']/p/a")
    WebElement shoppingcartlinkonsuccessMsg;

    @FindBy(xpath = "//span[@class='product-price']")
    WebElement subTotal;

    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement termsandconditionsCheckbox;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;

    @FindBy(xpath = "//div[@class='section select-billing-address']/div/select/option")
    List<WebElement> billingAddress;

    @FindBy(xpath = "(//input[@class='button-1 new-address-next-step-button'])[1]")
    WebElement billingAddressContinueButton;

    @FindBy(xpath = "//div[@class='section select-shipping-address']/div/select/option")
    List<WebElement> shippingAddress;

    @FindBy(xpath = "(//input[@class='button-1 new-address-next-step-button'])[2]")
    WebElement shippingAddressContinueButton;

    @FindBy(xpath = "(//div[@class='method-name'])[2]/input")
    WebElement shippingmethodtypeNextdayAir;

    @FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
    WebElement shippmentcontinuebutton;
    @FindBy(xpath = "(//div[@class='payment-details'])[1]")
    WebElement codbutton;

    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
    WebElement paymentcontinuebutton;

    @FindBy(xpath = "//div[@class='info']//table/tbody/tr/td/p")
    WebElement paymentmsg;

    @FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
    WebElement paymentinfocontuniebutton;

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
    WebElement orderConfirmButton;

    @FindBy(xpath = "//div[@class='title']/strong")
    WebElement successfullmsg;

    @FindBy(xpath = "//div[@class='section order-completed']/ul/li[1]")
    WebElement orderNumber;

    @FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
    WebElement finalContinueButton;

    @FindBy(xpath = "//div[@class='header-links']/ul/li[2]/a")
    WebElement logout;

    public EcomApp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void orderItem(WebDriver driver) throws InterruptedException {

        loginbutton.click();
        username.sendKeys("planittest78@gmail.com");
        password.sendKeys("123456");
        login.click();
        String usertexst = userid.getText();
        Assert.assertEquals(usertexst, "planittest78@gmail.com");
        shoppingCartlink.click();
        String count = cardqunty.getText();
        System.out.println("count :" + count);
        if (count.contains("0")) {
            books.click();
            bookitem.click();
            addtocart.click();
            shoppingCartlink.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removecheckbox);
            updateCart.click();
            String msg = emptycartmsg.getText();
            System.out.println(msg);
            Assert.assertEquals(msg, "Your Shopping Cart is empty!");

        } else {
            shoppingCartlink.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removecheckbox);
            updateCart.click();
            String msg = emptycartmsg.getText();
            System.out.println(msg);
            Assert.assertEquals(msg, "Your Shopping Cart is empty!");
        }
        Actions act = new Actions(driver);
        act.moveToElement(computersSection).build().perform();
        act.moveToElement(desktop).click().perform();
        computerlist.click();
        System.out.println("Computer Price per 1 unit is : " + computerPrice.getText());
        quantity.clear();
        quantity.sendKeys("3");
        addtocart.click();
        String message = successsMsg.getText();
        System.out.println(message);
        Assert.assertEquals(message, "The product has been added to your shopping cart");
        shoppingcartlinkonsuccessMsg.click();
        System.out.println("Sub total is:" + subTotal.getText());
        termsandconditionsCheckbox.click();
        checkout.click();

        for (WebElement address : billingAddress) {
            if (address.getText().contains("planit test, pragathi, Hyderabad 500090, India")) {
                address.click();
                break;
            }
        }
        billingAddressContinueButton.click();
        for (WebElement address : shippingAddress) {
            if (address.getText().contains("planit test, pragathi, Hyderabad 500090, India")) {
                address.click();
                break;
            }
        }
        shippingAddressContinueButton.click();
        shippingmethodtypeNextdayAir.click();
        shippmentcontinuebutton.click();
        codbutton.click();
        paymentcontinuebutton.click();
        String paymentmsgs = paymentmsg.getText();
        Assert.assertEquals(paymentmsgs, "You will pay by COD");
        paymentinfocontuniebutton.click();
        orderConfirmButton.click();
        System.out.println(successfullmsg.getText());
        System.out.println(orderNumber.getText());
        finalContinueButton.click();
        logout.click();
    }
}
