package com.college.Sockets.Simple;

import java.io.*;
import java.net.*;

// Server Class
class SServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server is waiting for a client...");
            Socket s = ss.accept();
            System.out.println("Client connected!");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter output = new PrintWriter(s.getOutputStream(), true);
            
            String message = input.readLine();
            System.out.println("Client says: " + message);
            output.println("Message received: " + message);
            
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}