package com.example.test;

import com.example.pages.AbstractDemo;
import org.testng.annotations.Test;

public class AbstractTest extends AbstractDemo {
    @Override
    public void adstmethod() {
        System.out.println("This is Abstract method implementation");
    }
    @Test
    public void call(){
        AbstractTest test=new AbstractTest();
        test.method1();
        test.adstmethod();
        System.out.println("test executed successfully 1");
        System.out.println("test executed successfully 2");
        System.out.println("test executed successfully 3");



    }
}
