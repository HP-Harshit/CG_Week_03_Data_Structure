package insertionsort.sortemployeeids;

import java.util.Arrays;

public class InsertionSort {

    // Static method to perform insertion sort
    public static int[] insertionSort(int[] employeeIDs) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < employeeIDs.length; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            // Move elements of employeeIDs[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            // Place the key in its correct position
            employeeIDs[j + 1] = key;
        }
        // Return the sorted array
        return employeeIDs;
    }

    public static void main(String[] args) {
        // Declare an array to store the employee IDs
        int[] employeeIDs = {107, 102, 110, 103, 105, 101, 109, 106, 104, 108};

        // Display the results before and after sorting
        System.out.println("Employee IDs before sorting: " + Arrays.toString(employeeIDs));
        System.out.println("Employee IDs after sorting: " + Arrays.toString(insertionSort(employeeIDs)));
    }
}
