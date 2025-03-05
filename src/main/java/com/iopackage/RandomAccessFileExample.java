package com.iopackage;

import java.io.*;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try {
            // Create a random access file in read/write mode
            RandomAccessFile file = new RandomAccessFile("D:\\Aleem\\randomfile.txt", "rw");

            // Write data to file
            file.writeUTF("Hello, Random Access File!");
            file.writeInt(42);

            // Move file pointer to the beginning
            file.seek(0);

            // Read the data from the file
            String message = file.readUTF();
            int number = file.readInt();

            System.out.println("Message: " + message);
            System.out.println("Number: " + number);

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

