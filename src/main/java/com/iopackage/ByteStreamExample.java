package com.iopackage;

import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) {
        // Read and Write with byte streams
        try {
            FileInputStream inputStream = new FileInputStream("D:\\Aleem\\input.txt");
            FileOutputStream outputStream = new FileOutputStream("D:\\Aleem\\output.txt");

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data); // Write byte by byte
            }

            inputStream.close();
            outputStream.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
