package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // Workbook varolan excelin workbook u idi, bunu oluşmamış bir excel için kullanamıyoruz
        XSSFWorkbook workbook = new XSSFWorkbook(); // hafızada bir workbook oluşturuldu
        XSSFSheet sheet = workbook.createSheet("Page1"); // içinde sheet oluşturdum
        Row row = sheet.createRow(0); // hafızada satır oluşturuldu
        Cell cell = row.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu
        cell.setCellValue("Hello World"); // hafızada bilgi yazıldı.
        for (int i = 1; i < 10; i++)
            row.createCell(i).setCellValue(i);
        // Yazma işlemi yapmak için YAZMA moduna geçilecek.(SAVE)
        String path = "src/test/java/ApachePOI/resource/NewWxwl.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasına yazıldı (save)
        workbook.close(); // workbook için ayrılan hafıza boşaltıldı. (excel kapatıldı)
        outputStream.close(); // yazma için açılan kanal kapatıldı. (program excel kanalı kapatıldı)
        System.out.println("Work done");
    }
}
