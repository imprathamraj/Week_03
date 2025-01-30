//Two Sum Problem
//Problem: Given an array and a target sum, find two indices such that their values add up to the target.
//Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.

package com.hashmaps_and_hashfunctions;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int arr[]={2,3,5,1,7,5,9};
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int target= 14;
        boolean find=false;
        for(int i =0 ;i< arr.length ; i++){
            int remaining = target - arr[i];
            if(hashMap.containsKey(remaining)){
                System.out.println(hashMap.get(remaining)+ " " + i);
                find =true;
                break;
            }

            hashMap.put(arr[i], i );
        }

        if(!find ){
            System.out.println("Element are not present in the array");
        }
    }
}
