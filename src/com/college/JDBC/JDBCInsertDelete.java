package com.college.JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/FUFA_BADMOSH"; // Database name
        String user = "root"; 
        String password = "Kevin@181869"; // Use your actual MySQL password

        Connection connection = null;
        PreparedStatement insertStmt = null;
        PreparedStatement deleteStmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database successfully!");

            // 🔹 INSERT Operation
            System.out.println("Enter DEPTNO to Insert:");
            int deptno = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter DNAME:");
            String dname = scanner.nextLine();

            System.out.println("Enter LOC:");
            String loc = scanner.nextLine();

            String insertQuery = "INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";
            insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setInt(1, deptno);
            insertStmt.setString(2, dname);
            insertStmt.setString(3, loc);

            int insertCount = insertStmt.executeUpdate();
            if (insertCount > 0) {
                System.out.println("✅ Record Inserted Successfully!");
            } else {
                System.out.println("❌ Insert Failed!");
            }

            // 🔹 DELETE Operation
            System.out.println("Enter DEPTNO to Delete:");
            int deleteDeptno = scanner.nextInt();

            String deleteQuery = "DELETE FROM DEPT WHERE DEPTNO = ?";
            deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, deleteDeptno);

            int deleteCount = deleteStmt.executeUpdate();
            if (deleteCount > 0) {
                System.out.println("✅ Record Deleted Successfully!");
            } else {
                System.out.println("❌ No Matching Record Found to Delete!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (insertStmt != null) insertStmt.close();
                if (deleteStmt != null) deleteStmt.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
