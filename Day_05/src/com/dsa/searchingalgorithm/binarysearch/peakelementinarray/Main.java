package com.dsa.searchingalgorithm.binarysearch.peakelementinarray;

public class Main {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1,1,};
        int peakElement = PeakElementInAnArray.peakElementInAnArray(arr);
        System.out.println("pivot element is " +peakElement);//return -1

        int arr2[]={1,2,3,4,5,6,4};
        peakElement = PeakElementInAnArray.peakElementInAnArray(arr2);
        System.out.println("pivot element is " +peakElement); //return 6


    }
}
