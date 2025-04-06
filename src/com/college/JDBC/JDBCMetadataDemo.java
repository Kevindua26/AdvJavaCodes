package com.college.JDBC;

import java.sql.*;

public class JDBCMetadataDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH";
        String user = "root"; // Change if needed
        String password = ""; // Add your MySQL password if needed

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // 1. DatabaseMetaData usage
            DatabaseMetaData dbMeta = conn.getMetaData();
            System.out.println("Database Product Name: " + dbMeta.getDatabaseProductName());
            System.out.println("Database Version: " + dbMeta.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMeta.getDriverName());
            System.out.println("Driver Version: " + dbMeta.getDriverVersion());
            System.out.println("User Name: " + dbMeta.getUserName());
            System.out.println("URL: " + dbMeta.getURL());
            System.out.println("---------------------------------------");

            // 2. Query data and use ResultSetMetaData
            String query = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            System.out.println("Table: DEPT");
            System.out.println("Total Columns: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsMeta.getColumnName(i) +
                        " | Type: " + rsMeta.getColumnTypeName(i) +
                        " | Size: " + rsMeta.getColumnDisplaySize(i));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
