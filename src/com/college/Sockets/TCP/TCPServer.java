package com.college.Sockets.TCP;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        try {
            String line, newLine;
            ServerSocket ss = new ServerSocket(6666);

            // communication endpoint for client and server
            while (true) {
                // waiting for socket connection
                Socket s = ss.accept();
                System.out.println("Server Started...");

                // DataInputStream to read data from the input stream
                DataInputStream inp = new DataInputStream(s.getInputStream());

                // DataOutputStream to write data to the output stream
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                DataInputStream in = new DataInputStream(System.in);

                // read a line text
                while (true) {
                    System.out.println("Press 'q' if you want to quit");
                    line = inp.readLine();

                    // writes in output stream as bytes
                    out.writeBytes(line + '\n');
                    System.out.println("Received from client: " + line);
                    newLine =in.readLine();
                    if(newLine.equals("q")) {
                        out.writeBytes("Server is down..." + '\n');
                        return;
                    } else {
                        out.writeBytes(newLine + '\n');
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
