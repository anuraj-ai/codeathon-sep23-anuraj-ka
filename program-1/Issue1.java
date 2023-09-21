//define a class to sort a string according to the frequency of character and return the final string

import java.util.*;
import java.util.Map.Entry;

public class Issue1 {
    public static void main(String[] args) {
        String s = "Hello world";
        System.out.println(frequencySort(s));

    }

    // define frequencySort method
    public static String frequencySort(String s) {
        // create a map to store the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        // loop through the string and store the frequency of each character in the map
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // create a priority queue to store the characters in the order of their frequency
        PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // add all the entries of the map to the priority queue
        pq.addAll(map.entrySet());
        // create a string builder to store the final string
        StringBuilder sb = new StringBuilder();
        // loop until the priority queue is empty
        while (!pq.isEmpty()) {
            // get the entry from the priority queue
            Entry<Character, Integer> entry = pq.poll();
            // get the character and its frequency from the entry
            char c = entry.getKey();
            int count = entry.getValue();
            // append the character to the string builder count number of times
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        // return the final string
        return sb.toString();
    }
}