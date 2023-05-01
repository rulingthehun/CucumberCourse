package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        //Var olan Excel'e yazma işlemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(0); // hafızada satır oluşturuldu
        Cell cell = row.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu
        cell.setCellValue("Hello World"); // hafızada bilgi yazıldı.
        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modu , kanalı kapatılıyor.

        // Yazma işlemi yapmak için YAZMA moduna geçilecek.(SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasına yazıldı (save)
        workbook.close(); // workbook için ayrılan hafıza boşaltıldı. (excel kapatıldı)
        outputStream.close(); // yazma için açılan kanal kapatıldı. (program excel kanalı kapatıldı)
        System.out.println("Work done");
    }
}
