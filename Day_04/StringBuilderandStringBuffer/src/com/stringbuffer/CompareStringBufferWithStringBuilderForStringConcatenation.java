/*StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings. For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.
*/
package com.stringbuffer;

public class CompareStringBufferWithStringBuilderForStringConcatenation {
    public static void main(String[] args) {
        long startTime, endTime;

        // Testing StringBuilder Performance
        startTime = System.nanoTime();

        StringBuilder sbd = new StringBuilder("Java");
        for (int i = 0; i < 100000; i++) {
            sbd.append(" hello");
        }
        endTime = System.nanoTime();

        // Output
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");


        // Testing StringBuffer Performance
        startTime = System.nanoTime();

        StringBuffer sbf = new StringBuffer("Java");
        for (int i = 0; i < 100000; i++) {
            sbf.append(" hello");
        }
        endTime = System.nanoTime();

        //Output
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
    }
}
