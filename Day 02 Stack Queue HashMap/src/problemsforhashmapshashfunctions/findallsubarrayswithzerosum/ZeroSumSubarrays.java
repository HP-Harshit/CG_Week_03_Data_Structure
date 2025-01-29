package problemsforhashmapshashfunctions.findallsubarrayswithzerosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {

    // Method to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        // Initialize with sum 0 at index -1 to handle cases where the subarray starts from index 0
        sumMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If cumulative sum is found in the map, zero-sum subarray exists
            if (sumMap.containsKey(cumulativeSum)) {
                result.add(new int[] { sumMap.get(cumulativeSum) + 1, i });
            }

            // Store the cumulative sum with the current index
            sumMap.put(cumulativeSum, i);
        }

        return result;
    }

    // Method to print the result subarrays
    public static void printSubarrays(List<int[]> subarrays, int[] arr) {
        for (int[] subarray : subarrays) {
            System.out.print("Subarray from index " + subarray[0] + " to " + subarray[1] + ": ");
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        printSubarrays(subarrays, arr);
    }
}

