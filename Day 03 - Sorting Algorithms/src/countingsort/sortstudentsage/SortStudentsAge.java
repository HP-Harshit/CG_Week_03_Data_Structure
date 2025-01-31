package countingsort.sortstudentsage;

import java.util.Arrays;

public class SortStudentsAge {

    // Static method to perform Counting Sort
    public static int[] countingSort(int[] ages) {
        int size = ages.length;
        int max = 0;

        // Find the maximum age in the array
        for (int age : ages) {
            max = Math.max(max, age);
        }

        // Initialize the count array with zeros
        int[] countArray = new int[max + 1];

        // Store the count of each age
        for (int age : ages) {
            countArray[age]++;
        }

        // Compute the cumulative count
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the result array by placing elements in their correct positions
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[countArray[ages[i]] - 1] = ages[i];
            countArray[ages[i]]--;
        }

        // Return the sorted array
        return result;
    }

    public static void main(String[] args) {
        // Array to store student ages
        int[] studentAges = {12, 15, 10, 14, 18, 13, 16, 11, 17, 15};

        // Display the ages before sorting
        System.out.println("Student Ages before sorting: " + Arrays.toString(studentAges));

        // Call the sorting algorithm
        int[] ages = countingSort(studentAges);

        // Display the ages after sorting
        System.out.println("\nStudent Ages after sorting: " + Arrays.toString(ages));
    }
}
