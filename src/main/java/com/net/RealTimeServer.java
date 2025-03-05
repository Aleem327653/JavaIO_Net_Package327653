package com.net;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class RealTimeServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10); // Pool to handle multiple clients
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connections
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                // Create a new thread to handle the client
                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Create a separate thread to handle incoming messages from the client
            Thread readThread = new Thread(new ReadFromClient(input));
            readThread.start();

            // Main thread sends messages to the client
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String serverMessage;
            while ((serverMessage = userInput.readLine()) != null) {
                output.println("Server: " + serverMessage); // Send message to the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//Thread to read messages from the client
class ReadFromClient implements Runnable {
 private BufferedReader input;
 
 public ReadFromClient(BufferedReader input) {
     this.input = input;
 }

 @Override
 public void run() {
     try {
         String clientMessage;
         while ((clientMessage = input.readLine()) != null) {
             System.out.println("Client: " + clientMessage); // Print received message from client
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}