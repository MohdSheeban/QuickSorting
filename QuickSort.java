import java.util.*;

// A class that implements the Quick Sort algorithm
class QuickSort {

    // Method to sort an array using Quick Sort
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the left and right sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Method to partition an array and return the pivot index
    private int partition(int[] arr, int low, int high) {
        // Choose the last element in the sub-array as the pivot
        int pivot = arr[high];

        // Initialize the pivot index to the low index
        int pivotIndex = low;

        // Loop through the sub-array from low to high - 1
        for (int i = low; i < high; i++) {
            // If the current element is less than or equal to the pivot,
            // swap it with the element at the pivot index and increment the pivot index
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;
                pivotIndex++;
            }
        }

        // Swap the pivot with the element at the pivot index
        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        // Return the pivot index
        return pivotIndex;
    }
}

// A class to test the QuickSort class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create an object of QuickSort class
        QuickSort qs = new QuickSort();

        // Sort the input array using Quick Sort
        qs.quickSort(arr, 0, size - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}