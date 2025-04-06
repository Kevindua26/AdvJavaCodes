package com.college.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/FUFA_BADMOSH"; // Ensure MySQL is running
        String user = "root"; // Replace with your MySQL username
        String password = ""; // Replace with your MySQL password

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

            // Create Statement
            statement = connection.createStatement();

            // Execute Query to fetch data from DEPT table
            String query = "SELECT * FROM DEPT";
            resultSet = statement.executeQuery(query);

            // Process Result
            System.out.println("DEPT Table Data:");
            while (resultSet.next()) {
                int deptNo = resultSet.getInt("DEPTNO");
                String dName = resultSet.getString("DNAME");
                String loc = resultSet.getString("LOC");

                System.out.println("DeptNo: " + deptNo + ", DName: " + dName + ", Loc: " + loc);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        } finally {
            // Close resources
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
