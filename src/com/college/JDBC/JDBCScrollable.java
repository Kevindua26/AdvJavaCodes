package com.college.JDBC;

import java.sql.*;

public class JDBCScrollable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH";
        String user = "root";
        String password = "Kevin@181869";

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

            // Create a scrollable (but read-only) ResultSet
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM DEPT");

            // Go to the last row and print
            if (resultSet.last()) {
                System.out.println("Last Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Go to the first row and print
            if (resultSet.first()) {
                System.out.println("First Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Go to the 2nd row and print
            if (resultSet.absolute(2)) {
                System.out.println("Row 2 - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Moving backward to the first row
            if (resultSet.previous()) {
                System.out.println("Moved Backward - DEPTNO: " + resultSet.getInt("DEPTNO") +
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
