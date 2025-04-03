package com.college.Sockets.InetAddress;

import java.net.*;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to retrieve InetAddress");
            e.printStackTrace();
        }
    }
}
