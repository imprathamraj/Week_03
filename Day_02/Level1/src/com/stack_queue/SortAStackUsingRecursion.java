/*Sort a Stack Using Recursion
Problem: Given a stack, sort its elements in ascending order using recursion.
Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.
*/
package com.stack_queue;
import java.util.Stack;
public class SortAStackUsingRecursion {
    private static void sortStackUsingRecursion(Stack<Integer> stack){
        if(!stack.isEmpty()){
            //pop the top element
            int top =stack.pop();
            //recursively for remaining element
            sortStackUsingRecursion(stack);
            //insert the pop element into appropriate position
            insertInSortOrder(stack, top);
        }
    }

    private static void insertInSortOrder(Stack<Integer> stack, int element) {
        //base case
        if(stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
            return;
        }
        //remove the element from second stack
        int top = stack.pop();
        //recursively until the condition satisfy
        insertInSortOrder(stack, element);
        //push element to its position
        stack.push(top);
    }

    //different approach better than
    private static void sortStackByIteration(Stack<Integer> stack){
        Stack<Integer>sortedStack = new Stack<>();

        while(!stack.isEmpty()){
            int topElement = stack.pop();

            while(!sortedStack.isEmpty() && sortedStack.peek()>topElement){
                stack.push(sortedStack.pop());
            }

            sortedStack.push(topElement);
        }

        while(!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);

        System.out.println("Given stack is: " + stack);
        //take O(n^2)
        sortStackUsingRecursion(stack);
        //sortStackByIteration(stack);
        System.out.println("Sorted stack is: " + stack);
    }

}