import java.io.*;
import java.net.*;

class TCPNewServer {
    public static void main(String args[]) throws Exception {
        try {
            String clientMessage, serverResponse;

            // Create a ServerSocket to listen on port 6789
            ServerSocket ss = new ServerSocket(6789);
            System.out.println("Server Started... Waiting for a client...");

            // Accept a client connection
            Socket s = ss.accept();
            System.out.println("Client connected!");

            // Input stream to read messages from the client
            DataInputStream inFromClient = new DataInputStream(s.getInputStream());
            // Output stream to send messages to the client
            DataOutputStream outToClient = new DataOutputStream(s.getOutputStream());
            // Input stream to read server user input from console
            DataInputStream inFromConsole = new DataInputStream(System.in);

            while (true) {
                // Read the message from the client
                clientMessage = inFromClient.readUTF();
                System.out.println("Received from client: " + clientMessage);

                // Check if the client wants to exit
                if (clientMessage.equals("q")) {
                    outToClient.writeUTF("Server is shutting down...");
                    break;
                }

                // Prompt server user for a response
                System.out.println("Enter a response for the client (or 'q' to exit): ");
                serverResponse = inFromConsole.readLine();

                // Send the response to the client
                outToClient.writeUTF(serverResponse);

                // Check if the server user wants to exit
                if (serverResponse.equals("q")) {
                    break;
                }
            }

            // Close resources
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}