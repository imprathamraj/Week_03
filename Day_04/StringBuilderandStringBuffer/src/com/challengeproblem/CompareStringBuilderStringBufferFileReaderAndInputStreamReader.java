/*Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader
Problem:
Write a program that:
Uses StringBuilder and StringBuffer to concatenate a list of strings 1,000,000 times.
Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and print the number of words in the file.
Approach:
StringBuilder and StringBuffer:
Create a list of strings (e.g., "hello").
Concatenate the strings 1,000,000 times using both StringBuilder and StringBuffer.
Measure and compare the time taken for each.
FileReader and InputStreamReader:
Read a large text file (100MB) using FileReader and InputStreamReader.
Count the number of words by splitting the text on whitespace characters.
Print the word count and compare the time taken for reading the file.
*/
package com.challengeproblem;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CompareStringBuilderStringBufferFileReaderAndInputStreamReader {
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        countWordsInFileUsingFileReader("C:\\Lab\\Week_03\\Day_04\\StringBuilderandStringBuffer\\src\\com\\challengeproblem\\large_text_file.txt"); // Change file path as needed
        countWordsInFileUsingInputStreamReader("C:\\Lab\\Week_03\\Day_04\\StringBuilderandStringBuffer\\src\\com\\challengeproblem\\large_text_file.txt"); // Change file path as needed
    }

    // Creating method to compare StringBuilder and StringBuffer
    private static void compareStringBuilderAndStringBuffer() {
        String text = "hello";
        int iterations = 1_000_000;

        //Start Time
        long startTime = System.nanoTime();

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        //End time
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Creating method to count words using FileReader
    private static void countWordsInFileUsingFileReader(String filePath) {
        //Start Time
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //End time
        long endTime = System.nanoTime();
        System.out.println("FileReader Word Count: " + wordCount);
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Creating method to count words using InputStreamReader
    private static void countWordsInFileUsingInputStreamReader(String filePath) {
        //Start time
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split(" ").length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //End time
        long endTime = System.nanoTime();
        //Outout
        System.out.println("InputStreamReader Word Count: " + wordCount);
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
