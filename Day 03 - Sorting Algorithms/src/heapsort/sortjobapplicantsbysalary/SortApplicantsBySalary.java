package heapsort.sortjobapplicantsbysalary;

import java.util.Arrays;

public class SortApplicantsBySalary {

    // Static method to heapify a subtree rooted at index i
    public static void heapify(double[] salary, int size, int i) {
        // Initialize largest as root
        int largest = i;
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < size && salary[left] > salary[largest]) {
            largest = left;
        }

        // If right child is larger than the current largest
        if (right < size && salary[right] > salary[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            double temp = salary[largest];
            salary[largest] = salary[i];
            salary[i] = temp;

            // Recursively heapify the affected subtree
            heapify(salary, size, largest);
        }
    }

    // Static method to perform Heap Sort
    public static void heapSort(double[] salary) {
        int size = salary.length;

        // Build a max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(salary, size, i);
        }

        // Extract elements from heap one by one
        for (int i = size - 1; i > 0; i--) {
            double temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            // Heapify the reduced heap
            heapify(salary, i, 0);
        }
    }

    public static void main(String[] args) {
        // Array to store 10 salary demands
        double[] salary = {25.99, 15.49, 45.75, 22.35, 10.99, 30.50, 18.75, 40.90, 12.99, 35.00};

        // Display the salary demands before sorting
        System.out.println("Salary demands before sorting: " + Arrays.toString(salary));

        // Sort the array using Heap Sort
        heapSort(salary);

        // Display the salary demands after sorting
        System.out.println("\nSalary demands after sorting: " + Arrays.toString(salary));
    }
}
