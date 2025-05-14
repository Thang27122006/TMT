package com.database;

import java.sql.*;

public class Mysql {

    private static Connection connection;

    private static String DATABASE = "javacuoiki";
    private static String USERNAME = "root";
    private static String PASSWORD = "12345";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để debug
        }
    }

    // Phương thức cho truy vấn SELECT, trả về ResultSet
    public static ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Phương thức cho INSERT, UPDATE, DELETE, trả về số hàng bị ảnh hưởng
    public static int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    // Lấy connection để sử dụng PreparedStatement
    public static Connection getConnection() {
        return connection;
    }
}