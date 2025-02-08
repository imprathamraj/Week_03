/*3. Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
Comparative Analysis:
Operations Count (N)
String (O(N²))
StringBuilder (O(N))
StringBuffer (O(N))
1,000
10ms
1ms
2ms
10,000
1s
10ms
12ms
1,000,000
30m (Unusable)
50ms
60ms

Expected Result:
StringBuilder & StringBuffer are much more efficient than String.
Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded.*/

package com.algorithmsruntimeanalysisandbigonotation;

public class StringConcatenationPerformance {
    //Method to concat using String
    public static void usingString(int[] array, String[] dataArray) {
        // Using String (Immutable, creates new object each time)
        String result = "";
        for (int i = 0; i < dataArray.length; i++) {
            result += dataArray[i];
        }
    }
    //Method to concat using StringBuilder
    public static void usingStringBuilder(int[] array, String[] dataArray) {
        // Using StringBuilder (Fast, mutable, thread-unsafe)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataArray.length; i++) {
            sb.append(dataArray[i]);
        }
    }
    //Method to concat using StringBuffer
    public static void usingStringBuffer(int[] array, String[] dataArray) {
        // Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < dataArray.length; i++) {
            sbf.append(dataArray[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1000, 10000, 1000000};

        for (int i = 0; i < array.length; i++) {
            System.out.println("__________________________________________________");
            System.out.println();

            String[] dataArray = new String[array[i]];
            // Filling data
            for (int j = 0; j < array[i]; j++) {
                dataArray[j] = "Java ";
            }

            // Start Time
            long startTime = System.nanoTime();
            usingString(array, dataArray);
            // End Time
            long endTime = System.nanoTime();
            System.out.println("String Time: " + (endTime - startTime) + " ms");

            // Start Time
            startTime = System.nanoTime();
            usingStringBuilder(array, dataArray);
            // End Time
            endTime = System.nanoTime();
            System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");


            // Start Time
            startTime = System.nanoTime();
            usingStringBuffer(array, dataArray);
            // End Time
            endTime = System.nanoTime();
            System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
        }
    }
}
