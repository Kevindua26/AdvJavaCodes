package com.college.Sockets.TCP;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String line, newLine;
        try {
            DataInputStream in = new DataInputStream(System.in);

            // communication endpoint for client and server
            Socket s = new Socket("LocalHost", 6666);

            // DataInputStream to read data from the input stream
            DataInputStream inp = new DataInputStream(s.getInputStream());

            // DataOutputStream to write data to the output stream
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            while (true) {
                newLine = in.readLine();
                if (newLine.equals("q")) {
                    out.writeBytes("Client is down..." + '\n');
                    return;
                } else {
                    out.writeBytes(newLine + '\n');
                }
                line = inp.readLine();
                System.out.println("Server says: " + line);
            }
        } catch (Exception e) {
            System.out.println("Caught error: " + e);
        }
    }
}
