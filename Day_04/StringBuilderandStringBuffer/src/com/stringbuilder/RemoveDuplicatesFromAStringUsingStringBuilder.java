/*StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.*/
package com.stringbuilder;

import java.util.HashSet;

public class RemoveDuplicatesFromAStringUsingStringBuilder {
    public static String removeDuplicates(String str) {
        // Creating object of StringBuilder
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        // Return statement
        return sb.toString();
    }

    public static void main(String[] args) {
        // Input
        String str1 = "aabc";

        // Calling method
        String result = removeDuplicates(str1);

        // Output
        System.out.println("Original String: " + str1);
        System.out.println("String without duplicates: " + result);
    }
}
