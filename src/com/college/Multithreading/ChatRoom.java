package com.college.Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ChatRoom {
    private Queue<String> messages = new LinkedList<>();

    public synchronized void sendMessage(String message) {
        messages.add(message);
        System.out.println("Message sent: " + message);
        notifyAll(); // Notify all users about the new message
    }

    public synchronized String receiveMessage() throws InterruptedException {
        while (messages.isEmpty()) {
            wait(); // Wait until a new message are available
        }
        String message = messages.poll();
        System.out.println("Message received: " + message);
        return message;
    }
}

class User implements Runnable {
    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                String message = "Hello from " + name + " - Message " + i;
                chatRoom.sendMessage(message);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ChatMain {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        Thread user1Thread = new Thread(new User("User 1", chatRoom));
        Thread user2Thread = new Thread(new User("User 1", chatRoom));

        user1Thread.start();
        user2Thread.start();

        user1Thread.start();
        user2Thread.start();
    }
}
