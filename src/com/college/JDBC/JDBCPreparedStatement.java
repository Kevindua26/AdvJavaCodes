package com.college.JDBC;

import java.sql.*;

public class JDBCPreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH"; // Database URL
        String user = "root"; 
        String password = ""; // Your MySQL password

        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database successfully!");

            // Prepare the SELECT statement
            String selectSQL = "SELECT * FROM DEPT";
            selectStmt = connection.prepareStatement(selectSQL);

            // Execute the query
            resultSet = selectStmt.executeQuery();

            // Display results
            System.out.println("|  DEPTNO  |      DNAME      |     LOC     |");

            while (resultSet.next()) {
                System.out.printf("|  %-7d | %-15s | %-10s |\n", resultSet.getInt("DEPTNO"),
                        resultSet.getString("DNAME"), resultSet.getString("LOC"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (selectStmt != null) selectStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
