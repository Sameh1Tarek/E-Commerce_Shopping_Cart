package com.example.shoppingcart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
    private static String url = "jdbc:mysql://localhost:3306/ecommerce_cart";
    private static String userName = "root";
    private static String password = "sameh";
    private static Connection connection = null;
    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,userName,password);
                System.out.println("connected");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
