package com.example.pages;

import org.testng.annotations.Test;

public class FindingThePageLoadTime extends Browser{
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        driver.get("https://www.flipkart.com/");
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - "+totalTime);

    }
}
