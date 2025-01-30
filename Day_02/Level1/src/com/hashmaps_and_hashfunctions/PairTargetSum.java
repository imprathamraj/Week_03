//Check for a Pair with Given Sum in an Array
//Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
//        Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.
package com.hashmaps_and_hashfunctions;

import java.util.HashMap;


public class PairTargetSum {


    static  int[] pairSumEqualsToTarget(int[] arr, int target){
        HashMap<Integer, Integer> hashMap =new HashMap<>();
        int currSum =0;
       for(int i =0 ;i < arr.length ; i++){
           int remaining = target - arr[i];
           if(hashMap.containsKey(remaining)){

             return new int[]{arr[i], remaining};
           }

           hashMap.put(arr[i], i );
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int arr[]={1,6,3,8,4,9};
        int target =10;
        int[] result = pairSumEqualsToTarget(arr, target);


        if (result[0] == -1 && result[1] == -1) {
            System.out.println("No pair found");
        } else {
            System.out.println("Pair with sum " + target + ": (" + result[0] + ", " + result[1] + ")");
        }
    }
}
