package com.example.pages;

import org.testng.annotations.*;

public class TestAnnotationsExample {
    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @Test(timeOut = 3000)
    public void test3() {
        System.out.println("test 3");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("After test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after Suite");
    }
}
