# Java Servlet Codes

<br>

### Write a servlet program to create a simple servlet and test it.

`java`
```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL mapping
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello, World!</h2>");
        out.println("</body></html>");
    }
}

```

<br><br>

### Write a servlet program to read the client request parameters

`java`
```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readParams")
public class ReadParamsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read parameters from request
        String name = request.getParameter("username");
        String email = request.getParameter("email");

        // Output the parameters back to the client
        out.println("<html><body>");
        out.println("<h2>Received Parameters</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("</body></html>");
    }

    // To support GET requests as well
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

```

`html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>Submit Form</title>
</head>
<body>
    <h2>Enter Your Details</h2>
    <form action="readParams" method="post">
        Name: <input type="text" name="username"><br><br>
        Email: <input type="email" name="email"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

```

<br><br>

### Implement a Servlet to generate Multiplication Table for a Number Entered in Html Page

`java`
```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiplicationTable")
public class MultiplicationTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the number from the form input
        String numberStr = request.getParameter("number");

        // Validate input
        try {
            int number = Integer.parseInt(numberStr);

            out.println("<html><body>");
            out.println("<h2>Multiplication Table for " + number + "</h2>");
            out.println("<table border='1' cellpadding='5'>");

            for (int i = 1; i <= 10; i++) {
                out.println("<tr><td>" + number + " x " + i + " = " + (number * i) + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h3>Invalid input. Please enter a valid number.</h3>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response); // Handle GET same as POST
    }
}

```

`html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>Multiplication Table</title>
</head>
<body>
    <h2>Enter a Number to Generate Multiplication Table</h2>
    <form action="multiplicationTable" method="post">
        <label>Number:</label>
        <input type="number" name="number" required>
        <input type="submit" value="Generate">
    </form>
</body>
</html>

```

<br><br>

### Develop an application/s to demonstrate all the core tags available in JSP (Declaration, Expression, Directive and Scriptlet Tag)

`jsp`
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>  <%-- Directive tag to import package --%>

<html>
<head>
    <title>JSP Core Tags Demo</title>
</head>
<body>

    <h2>Demonstrating JSP Core Tags</h2>

    <%-- Declaration Tag: Declaring a variable and a method --%>
    <%! 
        int counter = 0; 

        public String greetUser(String name) {
            return "Welcome, " + name + "!";
        }
    %>

    <%-- Scriptlet Tag: Java logic to update the counter --%>
    <%
        counter++;
        String username = "Kevin";
    %>

    <%-- Expression Tag: Outputting values --%>
    <p><strong>Current Date and Time:</strong> <%= new Date() %></p>
    <p><strong>Counter Value:</strong> <%= counter %></p>
    <p><strong>Greeting Message:</strong> <%= greetUser(username) %></p>

</body>
</html>

```

`bash`
```bash
http://localhost:8080/YourApp/coreTagsDemo.jsp
```

<br><br>

### Develop a JSP Application to accept Details from user and store it into the database table.

`sql`
```sql
CREATE DATABASE user_db;

USE user_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(100)
);
```

`html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>
    <form action="register.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>

```
`jsp`
```jsp
<%@ page import="java.sql.*" %>
<%
    // Read form data
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // DB connection details
    String jdbcURL = "jdbc:mysql://localhost:3306/user_db";
    String dbUser = "root";
    String dbPassword = "your_mysql_password"; // replace with your MySQL password

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, password);

        int result = stmt.executeUpdate();

        if(result > 0){
            out.println("<h3>Registration Successful!</h3>");
        } else {
            out.println("<h3>Registration Failed.</h3>");
        }

    } catch(Exception e){
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        try {
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        } catch(Exception e) {
            out.println("<h3>Cleanup Error: " + e.getMessage() + "</h3>");
        }
    }
%>
```

`bash`
```bash
// JDBC Driver Dependency
<apache-tomcat>/lib/

// RUN
http://localhost:8080/YourApp/register.html
```

<br><br>

### Develop a JSP Application to Authenticate User login as per registration details. If login success the forward user to Index Page otherwise show login failure Message

`sql`
```sql
CREATE DATABASE user_db;

USE user_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);
```

`html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h2>User Login</h2>
    <form action="login.jsp" method="post">
        Email: <input type="email" name="email" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>

```

`login.jsp`
```login.jsp
<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    String jdbcURL = "jdbc:mysql://localhost:3306/user_db";
    String dbUser = "root";
    String dbPassword = "your_mysql_password"; // change this

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    boolean loginSuccess = false;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        rs = stmt.executeQuery();

        if(rs.next()) {
            loginSuccess = true;
        }

    } catch(Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        try { if(rs != null) rs.close(); } catch(Exception e) {}
        try { if(stmt != null) stmt.close(); } catch(Exception e) {}
        try { if(conn != null) conn.close(); } catch(Exception e) {}
    }

    if(loginSuccess) {
        // Login successful, forward to index.jsp
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    } else {
        // Login failed
        out.println("<h3>Login Failed. Invalid email or password.</h3>");
    }
%>

```

`index.jsp`
```index.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Login Successful!</h2>
    <p>Welcome to the Index Page.</p>
</body>
</html>

```

`bash`
```bash
http://localhost:8080/YourApp/login.html
```

<br><br>

### Write a web based student registration application where students can register online with their enrolment number. The registered students should be able to log on to the site after getting registered. You are required to use JSP, Servlet and JDBC

`sql`
```sql
CREATE DATABASE student_portal;

USE student_portal;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enrolment_no VARCHAR(50) UNIQUE,
    name VARCHAR(100),
    password VARCHAR(100)
);
```

`File Structure`
```pgsql
StudentApp/
├── register.html
├── login.html
├── success.jsp
├── WEB-INF/
│   ├── web.xml
├── src/
│   ├── RegisterServlet.java
│   ├── LoginServlet.java
```

`register.html`
```register.html
<!DOCTYPE html>
<html>
<head><title>Student Registration</title></head>
<body>
<h2>Student Registration</h2>
<form action="RegisterServlet" method="post">
    Enrolment No: <input type="text" name="enrolment" required><br><br>
    Name: <input type="text" name="name" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
```

`login.html`
```login.html
<!DOCTYPE html>
<html>
<head><title>Student Login</title></head>
<body>
<h2>Student Login</h2>
<form action="LoginServlet" method="post">
    Enrolment No: <input type="text" name="enrolment" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
```

`RegisterServlet.java`
```RegisterServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String enrol = request.getParameter("enrolment");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_portal", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (enrolment_no, name, password) VALUES (?, ?, ?)");
            ps.setString(1, enrol);
            ps.setString(2, name);
            ps.setString(3, password);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("<h3>Registration successful! <a href='login.html'>Login Here</a></h3>");
            } else {
                out.println("<h3>Registration failed. Try again.</h3>");
            }

            con.close();

        } catch(Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
```

`LoginServlet.java`
```LoginServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String enrol = request.getParameter("enrolment");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_portal", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE enrolment_no=? AND password=?");
            ps.setString(1, enrol);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("studentName", rs.getString("name"));
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h3>Login Failed. Invalid credentials. <a href='login.html'>Try Again</a></h3>");
            }

            con.close();

        } catch(Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
```

`success.jsp`
```success.jsp
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Student Home</title></head>
<body>
    <h2>Welcome, <%= request.getAttribute("studentName") %>!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>
```

`web.xml`
```web.xml
<web-app>
    <servlet>
        <servlet-name>RegisterServlet</servlet-name>
        <servlet-class>RegisterServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>RegisterServlet</servlet-name>
        <url-pattern>/RegisterServlet</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/LoginServlet</url-pattern>
    </servlet-mapping>
</web-app>
```