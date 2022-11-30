package com.example.pages;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Excel_Reading {
    String path = "D:\\Test_Practice\\TestData\\Book1.xlsx";
    FileInputStream fis = new FileInputStream(path);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);

    public Excel_Reading() throws IOException {
    }

    public void read() throws IOException {
        int rowcount = sheet.getLastRowNum();
        for (int i = 0; i <= rowcount; i++) {
            int cellcount = sheet.getRow(i).getLastCellNum();

            for (int j = 0; j < cellcount; j++) {
                writedata();
                System.out.print(sheet.getRow(i).getCell(j));
                System.out.print(" | ");
            }
            System.out.println();
        }

    }

    public  void writedata() throws IOException {

        sheet.getRow(0).createCell(2).setCellValue("Last Name");
        sheet.getRow(1).createCell(2).setCellValue("Pavan");
        sheet.getRow(2).createCell(2).setCellValue("Nick");
        sheet.getRow(3).createCell(2).setCellValue("kumar");
        sheet.getRow(4).createCell(2).setCellValue("ramesh");
        sheet.getRow(5).createCell(2).setCellValue("vame");
        sheet.getRow(6).createCell(2).setCellValue("mignesh");
        sheet.getRow(7).createCell(2).setCellValue("babblu");
        sheet.getRow(8).createCell(2).setCellValue("revanth");
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
    }
}
