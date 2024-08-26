package yash.third;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderMethodExample {
    public static void main(String[] args) {
        readFile("example.txt");
    }

    // Method with a throws clause
    static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            // Code to read from the file
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
    }
}