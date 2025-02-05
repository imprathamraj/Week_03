package com.dsa.searchingalgorithm.binarysearch.rotationpointinrotatedsortedarray;

public class Main {
    public static void main(String[] args) {
        //Rotated array
        int arr[]={4,5,6,7,8,9,1,2,3}; //idx is 6 for smallest
        int idx= RotationPointInRotatedSortedArray.rotationPointInRotatedSortedArray(arr);
        System.out.println(idx);

        int arr2[]={1,2,3,4,5,6}; //idx 0 for smallest
        idx=RotationPointInRotatedSortedArray.rotationPointInRotatedSortedArray(arr2);
        System.out.println(idx);

    }
}
