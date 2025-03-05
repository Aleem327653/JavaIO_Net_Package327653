package com.iopackage;

import java.io.*;

public class FileOperationsExample {
    public static void main(String[] args) {
        File file = new File("D:\\Aleem\\file_example.txt");

        try {
            // Create a new file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            }

            // Check if it's a file or directory
            if (file.isFile()) {
                System.out.println("This is a file.");
            } else if (file.isDirectory()) {
                System.out.println("This is a directory.");
            }

            // Write something to the file
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, World!");
            writer.close();

            // Get file length
            System.out.println("File length: " + file.length() + " bytes");

            // Delete the file
            if (file.delete()) {
                System.out.println("File deleted.");
            } else {
                System.out.println("Failed to delete the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
