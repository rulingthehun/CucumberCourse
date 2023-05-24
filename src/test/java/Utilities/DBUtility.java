package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static Statement statement;
    public static Connection connection;
    public static ArrayList<ArrayList<String>> getListData(String query){
        // query: select * from city;
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        // DB den bütün satırları ve kolonları okuyup liste atıcam

        // 1- DB bağlantısını aç
        DBConnectionOpen();
        // 2- Sorguyu calıştır
        try {
            ResultSet rs = statement.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            // 3- Sorgu sonucnu tabloya doldur

            while (rs.next()) {
                ArrayList<String> line = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++)
                    line.add(rs.getString(i));
                table.add(line);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        // 4- DB bağlantısını kapat
        DBConnectionClose();
        return table;
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<ArrayList<String>> table = getListData("select * from actor");
        //System.out.println("table = " + table);
        for (List<String> line : table)
            System.out.println("line = " + line);
    }

    public static void DBConnectionOpen(){
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

    public static void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
