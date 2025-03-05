package com.net;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to the server on port 12345
            Socket socket = new Socket("localhost", 12345);

            // Step 2: Create input and output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Send a message to the server
            out.println("Hello from the client!");

            // Step 4: Read the server's response
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Step 5: Close the streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

