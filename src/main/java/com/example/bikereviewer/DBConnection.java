package com.example.bikereviewer;
import java.sql.*;
public class DBConnection {
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:sqlite:UsersDemo.db");
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
