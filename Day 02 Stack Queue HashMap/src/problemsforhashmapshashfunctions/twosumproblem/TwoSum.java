package problemsforhashmapshashfunctions.twosumproblem;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Method to find the two indices such that their values add up to the target sum
    public static int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the value and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the hash map
            if (map.containsKey(complement)) {
                // If the complement exists, return the indices
                return new int[] { map.get(complement), i };
            }

            // Add the current element and its index to the hash map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found (although the problem guarantees one solution)
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

