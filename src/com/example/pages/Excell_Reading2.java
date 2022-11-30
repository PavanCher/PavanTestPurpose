package com.example.pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excell_Reading2 {

    public  void reading(String path,int sheetNo) throws IOException {
        //String path = "D:\\Test_Practice\\TestData\\Book1.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetNo);//getSheet("sheetName");

        int lastRow = sheet.getLastRowNum();
        System.out.println("No of Rows = " + lastRow);

        for (int i = 0; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            int lastCell = row.getLastCellNum();

            for (int j = 0; j < lastCell; j++) {
                Cell cell = row.getCell(j);

                System.out.println(cell);
            }
            System.out.println();
        }
    }

}
