package com.college.Sockets;

import java.io.IOException;
import java.net.*;

public class DReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength()); // Fix: Correct string conversion
        System.out.println(str);
        ds.close();
    }
}
