/*StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate all the strings in the array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.*/

package com.stringbuffer;

public class ConcatenateStringsEfficientlyUsingStringBuffer {
    public static void main(String[] args) {
        // Creating StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Sample input of string in the form of array
        String [] arr = {"My" ," name", " is", " StringBuffer", "."};

        // Using for loop to iterate through each string
        for (int i = 0; i < arr.length; i++) {
            // Concatenating strings
            sb.append(arr[i]);
        }

        //Output to the user
        System.out.println(sb);
    }
}
