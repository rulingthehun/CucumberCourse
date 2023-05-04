package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExcelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2
    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> satirData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++)
                satirData.add(sheet.getRow(i).getCell(j).toString());
            list.add(satirData);
        }
        return list;
    }
    public static void writeToExcel(String path, Scenario scenario, String browserName, String time){

        File f=new File(path);

        if (!f.exists()){ // yok ise
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet= workbook.createSheet("CampusTest");
            // workbook-sheet-row-cell
            Row yeniSatir=sheet.createRow(0);

            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue(scenario.getName());

            yeniHucre=yeniSatir.createCell(1);
            yeniHucre.setCellValue(scenario.getStatus().toString());

            yeniHucre=yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            yeniHucre=yeniSatir.createCell(3);
            yeniHucre.setCellValue(time);

            // file save
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else // var ise
        {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            // workbook-sheet-row-cell
            int rowCount = sheet.getPhysicalNumberOfRows();
            Row yeniSatir=sheet.createRow(rowCount);
            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue(scenario.getName());

            yeniHucre=yeniSatir.createCell(1);
            yeniHucre.setCellValue(scenario.getStatus().toString());

            yeniHucre=yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            yeniHucre=yeniSatir.createCell(3);
            yeniHucre.setCellValue(time);

            // file save
            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    //fonksiyonu çağırıp test yapmak için kullanacağımız main
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = getListData
                ("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 6);
        for (ArrayList list1 : list) {
            System.out.println("list1 = " + list1);
            System.out.println();
        }
    }
}
