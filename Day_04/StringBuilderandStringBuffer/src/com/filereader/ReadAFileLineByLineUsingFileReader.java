/*FileReader Problem 1: Read a File Line by Line Using FileReader
Problem:
Write a program that uses FileReader to read a text file line by line and print each line to the console.
Approach:
Create a FileReader object to read from the file.
Wrap the FileReader in a BufferedReader to read lines efficiently.
Use a loop to read each line using the readLine() method and print it to the console.
Close the file after reading all the lines.
*/
package com.filereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ReadAFileLineByLineUsingFileReader {
    public static void main(String[] args) {
        //File path
        String fileName = "src\\com\\filereader\\Problem1.txt";

        try (FileReader fileReader = new FileReader(fileName);BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            // Looping until we reach EOL
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        //Returning exception if it occurs
        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}