package com.dsa.searchingalgorithm.linearsearch.searchspecificword;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Vivek", "Suraj", "Pratham", "Renu", "Savi"};
        String specificWord= "Suraj"; //Present in String array
        String specificWord2="Nisha"; //Not present in string array

        System.out.println(SearchForASpecificWordInString.searchForASpecificWordInString(words,specificWord)); //return Suraj
        System.out.println(SearchForASpecificWordInString.searchForASpecificWordInString(words,specificWord2)); //return not found
    }
}
