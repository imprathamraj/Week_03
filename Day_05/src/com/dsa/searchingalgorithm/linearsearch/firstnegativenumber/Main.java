package com.dsa.searchingalgorithm.linearsearch.firstnegativenumber;

import com.dsa.searchingalgorithm.linearsearch.firstnegativenumber.FirstNegativeNumber;

public class Main {
    public static void main(String[] args) {
        int arr[]={1,3,7,-6,3,6,-2,23,9};
        int arr2[]={2,4,5,6,7,3,4,5,6,7}; //method should return -1 because there are no negative number
        System.out.println(FirstNegativeNumber.firstNegativeNumber(arr)); //3
        System.out.println(FirstNegativeNumber.firstNegativeNumber(arr2)); //-1
    }
}
