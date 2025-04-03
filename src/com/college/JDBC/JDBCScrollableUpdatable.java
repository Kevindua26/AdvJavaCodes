package com.college.JDBC;

import java.sql.*;

public class JDBCScrollableUpdatable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH"; // Database URL
        String user = "root";
        String password = "Kevin@181869"; // Your MySQL password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database successfully!");

            // Create a Statement that supports scrollable and updatable ResultSet
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,  // Allows bidirectional navigation
                    ResultSet.CONCUR_UPDATABLE        // Allows updates to ResultSet
            );

            // Execute query and get Scrollable & Updatable ResultSet
            resultSet = statement.executeQuery("SELECT * FROM DEPT");

            // Move to last row and print
            if (resultSet.last()) {
                System.out.println("\nLast Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Move to first row and print
            if (resultSet.first()) {
                System.out.println("\nFirst Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Move to the second row and print
            if (resultSet.absolute(2)) {
                System.out.println("\nRow 2 - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Move to the previous row (backward navigation)
            if (resultSet.previous()) {
                System.out.println("\nPrevious Row - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Update the first row
            if (resultSet.first()) {
                System.out.println("\nUpdating First Row...");
                resultSet.updateString("DNAME", "FINANCE");
                resultSet.updateString("LOC", "NOIDA");
                resultSet.updateRow();

                // Print updated row
                System.out.println("After Update - DEPTNO: " + resultSet.getInt("DEPTNO") +
                        ", DNAME: " + resultSet.getString("DNAME") +
                        ", LOC: " + resultSet.getString("LOC"));
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
