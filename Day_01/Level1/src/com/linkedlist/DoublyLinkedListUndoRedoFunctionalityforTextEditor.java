/*8. Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
Add a new text state at the end of the list every time the user types or performs an action.
Implement the undo functionality (revert to the previous state).
Implement the redo functionality (revert back to the next state after undo).
Display the current state of the text.
Limit the undo/redo history to a fixed size (e.g., last 10 states).
Hint:
Use a doubly linked list where each node represents a state of the text.
The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
Keep track of the current state and adjust the next and prev pointers for undo/redo operations.
*/
package com.linkedlist;
class TextStateNode {
    String textState;
    TextStateNode prev;
    TextStateNode next;

    // Constructor
    public TextStateNode(String textState) {
        this.textState = textState;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListUndoRedoFunctionalityforTextEditor {
    private TextStateNode head;
    private TextStateNode current;
    private final int maxHistorySize = 10; // Limit for undo/redo history
    private int currentSize = 0;

    // Add a new text state
    public void addState(String text) {
        TextStateNode newNode = new TextStateNode(text);

        // Clear redo history
        if (current != null && current.next != null) {
            current.next = null;
        }

        if (head == null) {
            head = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;

        // Maintain history size limit
        if (currentSize == maxHistorySize) {
            head = head.next;
            head.prev = null;
        } else {
            currentSize++;
        }

        System.out.println("State added: \"" + text + "\"");
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No more states to undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed. Current state: \"" + current.textState + "\"");
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No more states to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed. Current state: \"" + current.textState + "\"");
    }

    // Display the current state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No states available.");
        } else {
            System.out.println("Current state: \"" + current.textState + "\"");
        }
    }

    // Display all states (for debugging purposes)
    public void displayAllStates() {
        TextStateNode temp = head;
        System.out.println("All states:");
        while (temp != null) {
            System.out.print("\"" + temp.textState + "\"");
            if (temp == current) {
                System.out.print(" (current)");
            }
            System.out.println();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListUndoRedoFunctionalityforTextEditor editor = new DoublyLinkedListUndoRedoFunctionalityforTextEditor();

        // Simulating actions
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        // Display current state
        editor.displayCurrentState();

        // Perform undo
        editor.undo();
        editor.undo();

        // Perform redo
        editor.redo();

        // Add a new state (clears redo history)
        editor.addState("Hello Java!");

        // Display all states
        editor.displayAllStates();

        // Perform undo
        editor.undo();

        // Display current state
        editor.displayCurrentState();
    }
}
