import java.io.*;
import java.net.*;

class TCPNewClient {
    public static void main(String args[]) throws Exception {
        try {
            String messageToSend, messageFromServer;

            // Connect to the server at localhost on port 6789
            Socket s = new Socket("localhost", 6789);
            System.out.println("Client Started... Connected to server!");

            // Output stream to send messages to the server
            DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
            // Input stream to read messages from the server
            DataInputStream inFromServer = new DataInputStream(s.getInputStream());
            // Input stream to read client user input from console
            DataInputStream inFromConsole = new DataInputStream(System.in);

            while (true) {
                // Prompt client user for a message
                System.out.println("Enter a message for the server (or 'q' to exit): ");
                messageToSend = inFromConsole.readLine();

                // Send the message to the server
                outToServer.writeUTF(messageToSend);

                // Check if the client wants to exit
                if (messageToSend.equals("q")) {
                    break;
                }

                // Read the response from the server
                messageFromServer = inFromServer.readUTF();
                System.out.println("Received from server: " + messageFromServer);

                // Check if the server is shutting down
                if (messageFromServer.equals("Server is shutting down...")) {
                    break;
                }
            }

            // Close the socket
            s.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}