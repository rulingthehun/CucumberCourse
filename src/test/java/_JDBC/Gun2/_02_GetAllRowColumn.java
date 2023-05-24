package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {
    @Test
    public void Test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        // ResultSet : data + MetaData (diğer bilgiler) (data dışındaki bilgiler kolon sayısı, tipleri, isimler)
        ResultSetMetaData rsmd = rs.getMetaData();
        //Sonuclarin haricindeki bilgiler: Kolon sayisi, isimleri, tipleri

        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);
            System.out.print("columnName = " + columnName);
            System.out.println(", columnType = " + columnType);
        }
    }

    @Test
    public void Test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        //Tablonun başlıkları
        for (int i = 1; i <= columnCount; i++)
            System.out.print(rsmd.getColumnName(i)+"\t");

        System.out.println();

        while (rs.next()){
            //Crosserın bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= columnCount; i++)
                System.out.print(rs.getString(i) + "\t");
            System.out.println();
        }
        System.out.println("columnCount = " + columnCount);
    }

    @Test
    public void Test3() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        //DAHA DUZENLİ HALİ
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        //Tablonun başlıkları
        for (int i = 1; i <= columnCount; i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));
        //PRINTF
        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

        System.out.println();

        while (rs.next()){
            //Crosserın bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= columnCount; i++)
                System.out.printf("%-20s",rs.getString(i));
            System.out.println();
        }
        System.out.println("columnCount = " + columnCount);
    }

    @Test
    public void Test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from actor");
        getTable2("select * from actor");
    }
    public void getTable(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()){
            //Crosserın bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));
            System.out.println();
        }
    }

    public void getTable2(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%d ", rsmd.getColumnDisplaySize(i));

        System.out.println();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                if (rsmd.getColumnDisplaySize(i) > 100) {
                    System.out.printf("%-100s ", rs.getString(i).substring(0, rs.getString(i).length() > 100 ? 100 : rs.getString(i).length()));
                } else
                    System.out.printf("%-" + rsmd.getColumnDisplaySize(i) + "s ", rs.getString(i));
            }

            System.out.println();
        }
    }
}

