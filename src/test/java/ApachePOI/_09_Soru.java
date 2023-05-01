package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class _09_Soru {
    /*
      Yeni bir excele merhaba Dünya 1 şeklinde yazdıktan sonra , programı tekrar
      çalıştırdığınızda aynı excelin bir alt satırına devam ediniz.
      Program her çalıştıkça aşağıdaki gibi olmalı
      Merhaba Dünya 1
      Merhaba Dünya 2
      Merhaba Dünya 3
       ....
       ....
       path="";
       File dosya=new File(path)

       if (dosya.exists()  // dosya var mı
     */
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/q9ExcelHello.xlsx";
        File f = new File(path);

        if (!f.exists()) {//Dosya yok ise
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Page1");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello World 1");
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("Work done");
        } else { //Dosya var ise
            FileInputStream inputStream;
            Workbook workbook;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Sheet sheet = workbook.getSheetAt(0);
            int rowCnt = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowCnt); // hafızada satır oluşturuldu
            Cell cell = row.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu
            cell.setCellValue("Hello World " + (rowCnt + 1)); // hafızada bilgi yazıldı.
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Exist work done");
        }
    }
}
