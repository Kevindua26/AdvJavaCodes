package com.college.JDBC;

import java.sql.*;

public class JDBCUpdatable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH"; // Updated database name
        String user = "root";
        String password = ""; // Ensure correct password

        // JDBC variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database successfully!");

            // Create an Updatable & Scrollable ResultSet
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("SELECT * FROM DEPT");

            // Move to last row and print
            if (resultSet.last()) {
                System.out.println("Last Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Move to first row and print
            if (resultSet.first()) {
                System.out.println("First Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Move to the 2nd row and print
            if (resultSet.absolute(2)) {
                System.out.println("Row 2 - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // 🔹 **Updating First Row**
            if (resultSet.first()) {
                resultSet.updateString("DNAME", "FINANCE");
                resultSet.updateString("LOC", "NOIDA");
                resultSet.updateRow(); // Apply update

                System.out.println("After Update - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
