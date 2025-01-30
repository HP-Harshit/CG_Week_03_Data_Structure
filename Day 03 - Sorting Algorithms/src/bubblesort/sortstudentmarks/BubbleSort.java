package bubblesort.sortstudentmarks;

import java.util.Arrays;

public class BubbleSort {

    // Static method to perform bubble sort
    public static int[] bubbleSort(int[] marks) {
        // Flag to check if swapping is done or not
        boolean isSwapped;
        // Iterating through the array
        for (int i = 0; i < marks.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < marks.length - 1 - i; j++) {
                // Comparing adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swapping elements using bitwise operator
                    marks[j] = marks[j] ^ marks[j + 1];
                    marks[j + 1] = marks[j] ^ marks[j + 1];
                    marks[j] = marks[j] ^ marks[j + 1];
                    // Marking flag as true
                    isSwapped = true;
                }
            }
            // If no swapping is done, the array is sorted
            if (!isSwapped) {
                break;
            }
        }
        // Returning the array
        return marks;
    }

    public static void main(String[] args) {
        // Declare an array to store the marks of the students
        int[] marks = {87, 85, 95, 92, 88, 89, 93, 81, 83};

        // Display the results before and after sorting
        System.out.println("Marks before sorting: " + Arrays.toString(marks));
        System.out.println("\nMarks after sorting: " + Arrays.toString(bubbleSort(marks)));
    }
}
