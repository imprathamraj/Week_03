/*InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read user input from the console and write the input to a file. Each input should be written as a new line in the file.
Approach:
Create an InputStreamReader to read from System.in (the console).
Wrap the InputStreamReader in a BufferedReader for efficient reading.
Create a FileWriter to write to the file.
Read user input using readLine() and write the input to the file.
Repeat the process until the user enters "exit" to stop inputting.
Close the file after the input is finished.
*/
package com.inputstreamreader;

import java.io.*;

public class ReadUserInputAndWriteToFileUsingInputStreamReader {
    public static void main(String[] args) {
        String filePath = "C:\\Lab\\Week_03\\Day_04\\StringBuilderandStringBuffer\\src\\com\\inputstreamreader\\UserInput.txt";

        //Try block
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text to save to file (type 'exit' to stop):");

            String userInput;
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Write input as a new line
            }

            System.out.println("User input saved to file: " + filePath);
        }
        //Returning exception if it occurs
        catch (IOException e) {
            e.printStackTrace(); // Print error details
        }
    }
}
