package quicksort.sortproductprices;

import java.util.Arrays;

public class SortProductPrices {

    // Static method to perform Quick Sort on the array
    public static void quickSort(double[] productPrices, int low, int high) {
        if (low < high) {
            // Find the partitioning index
            int pivot = partition(productPrices, low, high);
            // Recursively apply Quick Sort on the left subarray
            quickSort(productPrices, low, pivot - 1);
            // Recursively apply Quick Sort on the right subarray
            quickSort(productPrices, pivot + 1, high);
        }
    }

    // Static method to partition the array
    public static int partition(double[] productPrices, int low, int high) {
        // Choose the last element as the pivot
        double pivot = productPrices[high];
        // Initialize the index of the smaller element
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (productPrices[j] < pivot) {
                // Increment the index of the smaller element
                i++;
                // Swap productPrices[i] and productPrices[j]
                double temp = productPrices[i];
                productPrices[i] = productPrices[j];
                productPrices[j] = temp;
            }
        }
        // Swap productPrices[i+1] and productPrices[high]
        double temp = productPrices[i + 1];
        productPrices[i + 1] = productPrices[high];
        productPrices[high] = temp;
        // Return the partitioning index
        return i + 1;
    }

    public static void main(String[] args) {
        // Array to store 10 product prices
        double[] productPrices = {25.99, 15.49, 45.75, 22.35, 10.99, 30.50, 18.75, 40.90, 12.99, 35.00};

        // Display the product prices before sorting
        System.out.println("Product Prices before sorting: " + Arrays.toString(productPrices));

        // Sort the array using Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        // Display the product prices after sorting
        System.out.println("\nProduct Prices after sorting: " + Arrays.toString(productPrices));
    }
}
