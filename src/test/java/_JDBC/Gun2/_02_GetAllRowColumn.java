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
        // ResultSet : data +
        ResultSetMetaData rsmd = rs.getMetaData();
        //Sonuclarin haricindeki bilgiler: Kolon sayisi, isimleri, tipleri

        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);
    }
}
