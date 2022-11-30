package com.example.test;

import com.example.pages.Excel_Reading;
import com.example.pages.Excell_Reading2;
import org.testng.annotations.Test;

import java.io.IOException;

public class Excell_Test{
    Excel_Reading read=new Excel_Reading();
    Excell_Reading2 r=new Excell_Reading2();

    public Excell_Test() throws IOException {
    }

    @Test
    public void getdata() throws IOException {
        read.read();
        //read.writedata();
    }
    @Test
    public void readdata() throws IOException {
        r.reading("D:\\Test_Practice\\TestData\\Book1.xlsx",0);

    }
}
