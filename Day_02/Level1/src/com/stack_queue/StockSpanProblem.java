// Solving the Stock Span Problem
// Calculating the span (number of consecutive days the price was less than or equal to the current day's price)
// Using a stack to keep track of indices of prices in descending order

package com.stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    // Defining a method to calculate stock span for each day
    public static int[] stockSpain(int[] stockArray) {
        Stack<Integer> stack = new Stack<>(); // Creating a stack to store indices of stock prices
        int resultSpan[] = new int[stockArray.length]; // Initializing an array to store the span results

        // Iterating through each stock price
        for (int i = 0; i < stockArray.length; i++) {
            // Removing elements from the stack while the current price is greater than or equal to the top of the stack
            while (!stack.isEmpty() && stockArray[stack.peek()] <= stockArray[i]) {
                stack.pop();
            }

            // Calculating the span based on the stack condition
            resultSpan[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Pushing the current index onto the stack
            stack.push(i);
        }

        // Returning the computed spans
        return resultSpan;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = stockSpain(prices);

        // Printing the stock span result
        System.out.println("Stock Spans: " + Arrays.toString(result));
    }
}
