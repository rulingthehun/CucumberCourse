package _JDBC.Gun1;

import org.testng.annotations.*;
import java.sql.*;

public class _02_BeforeAfter {
    public Statement statement;
    public Connection connection;
    @BeforeTest
    public void DBConnectionOpen(){
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        rs.next();
        String languageName = rs.getString(2);
        System.out.println("languageName = " + languageName);

        rs.next();
        System.out.println("rs = " + rs.getString(2));

        rs.next();
        System.out.println("rs = " + rs.getString(2));
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        rs.next();
        String languageName = rs.getString(2);
        System.out.println("languageName = " + languageName);

        rs.next();
        System.out.println("rs = " + rs.getString(2));

        rs.previous();
        System.out.println("rs = " + rs.getString(2));
    }





}
