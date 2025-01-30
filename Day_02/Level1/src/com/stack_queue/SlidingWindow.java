//Sliding Window Maximum
//Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
//Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.

package com.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    static  void printMaxInSlide(int arr[] ,int k){
        Deque<Integer> deque = new LinkedList<>();

        //for starting k element
        for(int i=0; i<k;i++){
            while(!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        //for remaining element
        for(int i=k; i< arr.length;i++){

            System.out.print(arr[deque.peekFirst()]+" ");

            //clean the window update new window of size k
            if(!deque.isEmpty() && deque.peekFirst()== i-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]){
                deque.removeLast();

            }
            deque.addLast(i);
        }
        System.out.println(arr[deque.peekFirst()]);
    }



    public static void main(String[] args) {
        int arr[] = { 5,2,14,12,112,91 };
        int K = 3;
        printMaxInSlide(arr,K);

    }
}
