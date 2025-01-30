package mergesort.sortanarrayofbookprices;

import java.util.Arrays;

public class SortBookPrices {

    // Static method to perform merge sort on the array
    public static void mergeSort(double[] bookPrices, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort the first and second halves
            mergeSort(bookPrices, left, mid);
            mergeSort(bookPrices, mid + 1, right);

            // Merge the sorted halves
            mergeSorted(bookPrices, left, mid, right);
        }
    }

    // Static method to merge the sorted halves
    public static void mergeSorted(double[] bookPrices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        double[] leftPrices = new double[n1];
        double[] rightPrices = new double[n2];

        // Copy data to temporary arrays
        System.arraycopy(bookPrices, left, leftPrices, 0, n1);
        System.arraycopy(bookPrices, mid + 1, rightPrices, 0, n2);

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftPrices[i] <= rightPrices[j]) {
                bookPrices[k++] = leftPrices[i++];
            } else {
                bookPrices[k++] = rightPrices[j++];
            }
        }

        // Copy remaining elements of leftPrices[], if any
        while (i < n1) {
            bookPrices[k++] = leftPrices[i++];
        }

        // Copy remaining elements of rightPrices[], if any
        while (j < n2) {
            bookPrices[k++] = rightPrices[j++];
        }
    }

    public static void main(String[] args) {
        // Array to store 10 book prices
        double[] bookPrices = {25.99, 15.49, 45.75, 22.35, 10.99, 30.50, 18.75, 40.90, 12.99, 35.00};

        // Display the book prices before sorting
        System.out.println("Book Prices before sorting: " + Arrays.toString(bookPrices));

        // Sort the array using merge sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        // Display the book prices after sorting
        System.out.println("\nBook Prices after sorting: " + Arrays.toString(bookPrices));
    }
}
