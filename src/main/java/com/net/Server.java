package com.net;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket that listens on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for client connection...");

            // Step 2: Accept an incoming connection from the client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Step 3: Create input and output streams to communicate with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 4: Read data from the client
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Step 5: Send a response to the client
            out.println("Hello from the server!");

            // Step 6: Close the streams and socket
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

