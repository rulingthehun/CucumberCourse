package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aranacak sütun = ");
        int arananSutun = scanner.nextInt();

        String donenSonuc = find(arananSutun);
        System.out.println("donenSonuc = \n" + donenSonuc);

    }

    public static String find(int arananSutun) {
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
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if (sheet.getRow(i).getCell(arananSutun) != null)
            donecek += sheet.getRow(i).getCell(arananSutun) + "\n";
        return donecek;
    }
}
