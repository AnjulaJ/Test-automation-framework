package com.anjula.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelFile {

    private static FileInputStream inputStream;
    private static XSSFWorkbook workBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

    public static String getCellValue(String fileName,String sheetName, int rowNo, int cellNo)
    {
        try
        {
            inputStream= new FileInputStream(fileName);
            workBook= new XSSFWorkbook(inputStream);
            excelSheet=workBook.getSheet(sheetName);
            cell= workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

            workBook.close();

            return cell.getStringCellValue();
        }

        catch(Exception e)
        {
            return "";
        }
    }

    public static int getRowCount(String fileName,String sheetName)
    {
        try
        {

            inputStream= new FileInputStream(fileName);
            // create XSSFWorkbook Class object for excel file manipulation

            workBook= new XSSFWorkbook(inputStream);
            excelSheet=workBook.getSheet(sheetName);

            // get total no. of rows
            int ttlRows= excelSheet.getLastRowNum() + 1;

            workBook.close();

            return ttlRows;
        }

        catch(Exception e)
        {
            return 0;
        }
    }

    public static int getColCount(String fileName,String sheetName)
    {
        try
        {
            inputStream= new FileInputStream(fileName);
            // create XSSFWork Class object for excel file manipulation
            workBook= new XSSFWorkbook(inputStream);
            excelSheet=workBook.getSheet(sheetName);

            //get total no. of column
            int ttlCells= excelSheet.getRow(0).getLastCellNum();

            workBook.close();
            return ttlCells;
        }

        catch(Exception e)
        {
            return 0;
        }
    }

    @DataProvider(name="LoginDataProvider")
    public String[][] LoginDataProvider()
    {


        int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
        int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");

        String data[][]= new String[ttlRows-1][ttlColumns];

        for(int i=1;i<ttlRows;i++)
        {
            for(int j=0;j<ttlColumns;j++)
            {
                data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
            }
        }
        return data;
    }




    public String getStringData(int sheetIndex,int row,int column)
    {
        return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    public String getStringData(String sheetName,int row,int column)
    {
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getNumericData(String sheetName,int row,int column)
    {
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

}
