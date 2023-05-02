package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _11_Task2 {
    /**  Soru 2:
     * yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/task2.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("task2");
        Row row = sheet.createRow(0);
        Cell cell = null;
        for (int i = 0; i < 100; i++) {
            cell = row.createCell(i);
            cell.setCellValue(i + " x " + i + " = " + i * i);
            if ((i-1) * (i-1) % 10 == 0) {
                row.createCell(i);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
