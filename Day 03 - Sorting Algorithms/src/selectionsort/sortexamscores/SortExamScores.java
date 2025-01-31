package selectionsort.sortexamscores;

import java.util.Arrays;

public class SortExamScores {

    // Static method to perform selection sort
    public static void selectionSort(int[] scores) {
        // Iterate through the array
        for (int i = 0; i < scores.length - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                // If the current element is smaller than the minimum element, update the minimum index
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            if (i != minIndex) {
                scores[i] = scores[i] ^ scores[minIndex];
                scores[minIndex] = scores[i] ^ scores[minIndex];
                scores[i] = scores[i] ^ scores[minIndex];
            }
        }
    }

    public static void main(String[] args) {
        // Declare an array to store the exam scores
        int[] scores = {87, 85, 95, 92, 88, 89, 93, 81, 83};

        // Display the scores before sorting
        System.out.println("Scores before sorting: " + Arrays.toString(scores));

        // Sort the scores using selection sort
        selectionSort(scores);

        // Display the scores after sorting
        System.out.println("\nScores after sorting: " + Arrays.toString(scores));
    }
}
