package problemsforhashmapshashfunctions.longestconsecutivesequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive elements sequence
    public static int longestConsecutive(int[] nums) {
        // Create a HashMap to store elements and their presence
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int num : nums) {
            // Store each number in the HashMap
            numMap.put(num, true);
        }

        // Variable to keep track of the longest streak
        int longestStreak = 0;

        // Iterate through the numbers in the array
        for (int num : nums) {
            // Check if the current number is the start of a sequence
            if (!numMap.containsKey(num - 1)) {
                // Starting number of the sequence
                int currentNum = num;

                // Length of the current sequence
                int currentStreak = 1;

                // Check the length of the sequence by checking consecutive numbers
                while (numMap.containsKey(currentNum + 1)) {
                    // Move to the next consecutive number
                    currentNum += 1;

                    // Increase the length of the current sequence
                    currentStreak += 1;
                }

                // Update the longest streak if the current sequence is longer
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // Return the length of the longest consecutive sequence
        return longestStreak;
    }

    public static void main(String[] args) {
        // Example array
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Print the result of the longest consecutive sequence
        System.out.println("Length of the longest consecutive sequence: " + longestConsecutive(nums));  // Output: 4
    }
}
