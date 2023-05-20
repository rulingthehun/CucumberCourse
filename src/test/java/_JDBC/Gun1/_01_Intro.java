package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {
    @Test
    public void test1() throws SQLException {
        // başlangıç bilgilerini girme.
        //     javaBağlanti : mysql e bağlantı: url(hostname) : port / DB name
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        // connection açılıyor (like fileinputstream)
        Connection connection = DriverManager.getConnection(url, username, password); //baglatiya click

        Statement statement = connection.createStatement(); // sorgulari calistirmam icin sayfa ac

        ResultSet resultSet = statement.executeQuery("select * from actor"); // sorgunun sonuclari olustu, DB de bekliyor
        //Hizli calismak icin sonuclarin hepsi pc ye gelmiyor

        resultSet.next(); // Ilk satir bilgisayara geldi

        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        System.out.println("1th line firstName and lastName = " + firstName + " " + lastName);

        resultSet.next(); //2. satir

        firstName = resultSet.getString("first_name");
        lastName = resultSet.getString("last_name");
        System.out.println("2nd line firstName and lastName = " + firstName + " " + lastName);

        connection.close();


    }
}
