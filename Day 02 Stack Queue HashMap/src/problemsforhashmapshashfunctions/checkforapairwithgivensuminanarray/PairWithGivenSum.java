package problemsforhashmapshashfunctions.checkforapairwithgivensuminanarray;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {

    // Method to check if a pair with the given sum exists in the array
    public static boolean hasPairWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int val = target - num;
            if (map.containsKey(val)) {
                System.out.println("Pair found: (" + val + ", " + num + ")");
                return true;
            }
            // Store the number in the hash map
            map.put(num, 1);
        }

        System.out.println("No pair found with the given sum.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        hasPairWithSum(arr, target);
    }
}

