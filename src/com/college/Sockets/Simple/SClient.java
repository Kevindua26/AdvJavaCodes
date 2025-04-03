package com.college.Sockets.Simple;

import java.io.*;
import java.net.*;

// Client Class
class SClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter output = new PrintWriter(s.getOutputStream(), true);
            
            output.println("Hello, Server!");
            String response = input.readLine();
            System.out.println("Server Response: " + response);
            
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
