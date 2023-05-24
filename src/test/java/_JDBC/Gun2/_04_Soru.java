package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;
import java.sql.*;

public class _04_Soru extends JDBCParent {
    // Soru :  Actor tablsosundaki tüm verileri yeni excel e yazdırınız.
    @Test
    public void Test4() throws SQLException {

        getTable("select * from actor");
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
}
