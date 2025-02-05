//Search for a Specific Word in a List of Sentences
//Problem:
//You are given an array of sentences (strings). Write a program that performs Linear Search to
// find the first sentence containing a specific word. If the word is found, return the sentence.
// If no sentence contains the word, return "Not Found".
//Approach:
//Iterate through the list of sentences.
//For each sentence, check if it contains the specific word.
//If the word is found, return the current sentence.
//If no sentence contains the word, return "Not Found".
package com.dsa.searchingalgorithm.linearsearch.searchspecificword;

public class SearchForASpecificWordInString {
    //Method to find specific word in string
    public static String searchForASpecificWordInString(String []words, String specificWord){
        int length= words.length;
        //comparing the String words with specific word
        for(int index=0; index<length ; index++){
            if(words[index].equals(specificWord)){
                //If found direct return word from string
                return words[index];
            }
        }
        //If not found returns Not found
        return "Not Found";
    }
}
