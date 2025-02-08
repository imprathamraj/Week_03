/*5. Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Comparative Analysis:
Fibonacci (N)
Recursive (O(2ⁿ))
Iterative (O(N))
10
1ms
0.01ms
30
5s
0.05ms
50
Unfeasible (>1hr)
0.1ms

Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.*/
package com.algorithmsruntimeanalysisandbigonotation;

public class RecursiveVsIterativeFibonacciComputation {
    //Recursive method
    public static int fibonacciRecursive(int n) {

        if (n <= 1){
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);


    }

    //Iterative method
    public static int fibonacciIterative(int n) {

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int [] array = {10,30,50};
        for (int i : array) {
            System.out.println("____________________________________________");

            //Start Time
            long startTime = System.nanoTime();
            fibonacciIterative(i);
            //End Time
            long endTime = System.nanoTime();
            //Output
            System.out.println("Time taken by Recursive method: " + (endTime - startTime)/10000 );

            //Start Time
            startTime = System.nanoTime();
            fibonacciRecursive(i);
            //End Time
            endTime = System.nanoTime();
            //Output
            System.out.println("Time taken by Iterative method: " + (endTime - startTime)/10000 );
        }
    }
}
