package com.net;
import java.io.*;
import java.net.*;

public class RealTimeClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Start a new thread to read server responses
            Thread readThread = new Thread(new ReadFromServer(serverInput));
            readThread.start();

            System.out.println("Connected to server. Type messages to send:");

            String message;
            while ((message = userInput.readLine()) != null) {
                serverOutput.println(message); // Send user input to server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Thread to read messages from the server
class ReadFromServer implements Runnable {
    private BufferedReader serverInput;

    public ReadFromServer(BufferedReader serverInput) {
    	
    	
        this.serverInput = serverInput;
    }

    @Override
    public void run() {
        try {
            String serverMessage;
            while ((serverMessage = serverInput.readLine()) != null) {
                System.out.println("Server says: " + serverMessage); // Print received message from server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
