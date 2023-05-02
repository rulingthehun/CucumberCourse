package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Task1 {
    /**
     * Soru 1:
     * yeni excel
     * Çarpım tablosunu excele yazdırınız.
     * 1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     * sıfırdan excel oluşturarak.
     * her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/task1.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("task1");
        Row row = null;
        for (int i = 1; i < 101; i++) {
            row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(i + " x " + i + " = " + i * i);
            if ((i-1) * (i-1) % 10 == 0) {
                sheet.createRow(i);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
