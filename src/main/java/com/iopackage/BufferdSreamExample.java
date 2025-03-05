package com.iopackage;

import java.io.*;

public class BufferdSreamExample {
    public static void main(String[] args) {
        try {
            // BufferedReader for reading text efficiently
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Aleem\\bufferinput.txt"));
            // BufferedWriter for writing text efficiently
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Aleem\\bufferoutput.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Write new line after each line
            }

            reader.close();
            writer.close();
            System.out.println("Buffered file copy completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

