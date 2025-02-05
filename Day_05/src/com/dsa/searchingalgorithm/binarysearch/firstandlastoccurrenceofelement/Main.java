package com.dsa.searchingalgorithm.binarysearch.firstandlastoccurrenceofelement;

public class Main {
    public static void main(String[] args) {
        int arr[]= {2,2,2,3,3,4,5,6,7,8,9,9,9};
        int target =3;
        int result[] = FirstAndLastOccurrenceOfElementInSortedArray.firstAndLastOccurrenceOfElement(arr,target);

        System.out.println("Target "+ target + " first occurrence index is: "+ result[0]
                         +"\nlast occurrence index is: "+result[1]);
    }
}
