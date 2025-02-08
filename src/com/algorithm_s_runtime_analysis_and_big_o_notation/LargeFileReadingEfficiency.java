/*4. Problem Statement: Large File Reading Efficiency
Objective:
Compare FileReader (Character Stream) and InputStreamReader (Byte Stream) when reading a large file (500MB).
Approach:
FileReader: Reads character by character (slower for binary files).
InputStreamReader: Reads bytes and converts to characters (more efficient).
Comparative Analysis:
File Size
FileReader Time
InputStreamReader Time
1MB
50ms
30ms
100MB
3s
1.5s
500MB
10s
5s

Expected Result:
InputStreamReader is more efficient for large files.
FileReader is preferable for text-based data.*/
package com.algorithm_s_runtime_analysis_and_big_o_notation;

import java.io.*;

public class LargeFileReadingEfficiency {
    //Method to use FileReader
    public static void usingFileReader(File file) {
        try (FileReader fr = new FileReader(file)) {
            int i;
            while ((i = fr.read()) != -1) {
                //System.out.print((char) i);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Method to use InputStreamReader
    public static void usingInputStreamReader(File file) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
            int i;
            while ((i = isr.read()) != -1) {
                //System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        //Files
        File file_1_MB = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Day_06\\Day_06\\src\\com\\algorithm_s_runtime_analysis_and_big_o_notation\\1mb-examplefile-com.txt");
        File file_100_MB = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Day_06\\Day_06\\src\\com\\algorithm_s_runtime_analysis_and_big_o_notation\\100mb-examplefile-com.txt");
        File file_500_MB = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Day_06\\Day_06\\src\\com\\algorithm_s_runtime_analysis_and_big_o_notation\\500mb-example-com.txt");

        File[] files = {file_1_MB, file_100_MB, file_500_MB};

        for (int i = 0; i < files.length; i++) {
            System.out.println("________________________________________");


            //Start time
            long start =  System.nanoTime();
            usingFileReader(files[i]);
            //End Time
            long end =  System.nanoTime();
            System.out.println("Using FileReader - " + (end - start)/100000000);


            //Start Time
            start =  System.nanoTime();
            usingInputStreamReader(files[i]);
            //End Time
            end =  System.nanoTime();
            System.out.println("Using InputStreamReader - " + (end - start)/10000000);
        }
    }
}