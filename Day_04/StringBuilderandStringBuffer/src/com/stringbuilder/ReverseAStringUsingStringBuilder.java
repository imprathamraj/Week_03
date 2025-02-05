/*StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.*/
package com.stringbuilder;

public class ReverseAStringUsingStringBuilder {
    //Method to reverse string
        public static String reverse(String str) {
            //Creating a new StringBuilder object
            StringBuilder sb = new StringBuilder();

            //Using append method
            sb.append(str);

            //Using reverse method
            sb.reverse();

            //returning sb in string format
            return sb.toString();
        }

        public static void main(String[] args) {
            //input
            String input = "hello";

            //Method calling
            String output = reverse(input);

            //output
            System.out.println("Irreversible String: " + input);
            System.out.println("Reversed string: " + output);
        }
}

