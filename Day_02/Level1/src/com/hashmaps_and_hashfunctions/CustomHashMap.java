package com.hashmaps_and_hashfunctions;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    // Node class to represent each entry in the hash map
    private static class Node<K, V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] table;
    private int size;

    // Constructor to initialize the hash map with a given size
    public CustomHashMap(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hash function to map a key to an index
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert a key-value pair into the hash map
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if the key already exists, and update the value if so
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new node to the list
        bucket.add(new Node<>(key, value));
        size++;
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair from the hash map
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    // Check if a key exists in the hash map
    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    // Get the number of elements in the hash map
    public int size() {
        return size;
    }

    // Check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(10);

        // Insertion
        map.put("pen", 3);
        map.put("pencil", 5);
        map.put("rubber", 2);

        // Retrieve values
        System.out.println("pen: " + map.get("pen")); // Output: 3
        System.out.println("pencil: " + map.get("pencil")); // Output: 5
        System.out.println("rubber: " + map.get("rubber")); // Output: 2

        // Check if a key exists
        System.out.println("Contains 'pencil': " + map.containsKey("pencil")); // Output: true
        System.out.println("Contains 'sharpner': " + map.containsKey("sharpner")); // Output: false

        // Remove a key
        map.remove("pencil");
        System.out.println("Contains 'pencil' after removal: " + map.containsKey("pencil")); // Output: false

        // Size and isEmpty check
        System.out.println("Size: " + map.size()); // Output: 2
        System.out.println("Is map empty? " + map.isEmpty()); // Output: false
    }
}
