package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    /**
     * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
     * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
     * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
     * bulup ve sonucun döndürülmesi için metod kullanınız.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aranacak kelime = ");
        String arananKelime = scanner.next();

        String donenSonuc = find(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);

    }

    public static String find(String arananKelime) {
        String donecek = "";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            //Row row = sheet.getRow(i);
            //Cell cell = row.getCell(0);
            //if (cell.toString().equalsIgnoreCase(arananKelime)) {
            //    for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
            //        donecek += row.getCell(j) + " ";
            //    }
            //2. yöntem
            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(arananKelime)) {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++)
                    donecek += sheet.getRow(i).getCell(j) + " ";
            }
        }
        return donecek;
    }
}
