package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        // next(): bulunduğu noktadan bir sonraki row
        // previous() : bulunduğu noktadan bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(15); //15. satira git
        System.out.println(rs.getString("title"));

        rs.absolute(-15); // Sondan 15. satira git
        System.out.println(rs.getString("title"));

        rs.first(); // Ilk satira gider
        System.out.println(rs.getString("title"));

        rs.absolute(10);
        System.out.println(rs.getString("title"));

        rs.relative(10);
        System.out.println(rs.getString("title"));
    }
}
