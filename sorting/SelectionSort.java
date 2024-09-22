package sorting;

import java.util.Arrays;

public class SelectionSort {
   public static void main(String[] args) {

      int[] array = { 2, 8, 4, -1, 6, 7, 5, 10, -1 };
      int[] sortedArray = sortArray(array);
      System.out.println(Arrays.toString(sortedArray));
   }

   static void swap(int[] A, int x, int y) {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }

   public static int[] sortArray(int[] arr) {
      int n = arr.length;

      for (int i = 0; i < n - 1; i++) {
         int min = arr[i];
         int indexOfMinimumElement = i;
         for (int j = i; j < n; j++) {
            if (arr[j] < min) {
               min = arr[j];
               indexOfMinimumElement = j;
            }
         }
         swap(arr, i, indexOfMinimumElement);
      }
      return arr;
   }

   // TODO (@mrinaljain) Need to understand logic for this
   public static void stableSelectionSort(int[] arr) {
      int n = arr.length;

      // Traverse through all elements
      for (int i = 0; i < n - 1; i++) {
         // Find the minimum element in unsorted array
         int minIndex = i;
         for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
               minIndex = j;
            }
         }

         // Instead of swapping, store the minimum element
         int minValue = arr[minIndex];

         // Shift elements of the sorted segment to the right
         while (minIndex > i) {
            arr[minIndex] = arr[minIndex - 1];
            minIndex--;
         }

         // Place the minimum element at its correct position
         arr[i] = minValue;
      }
   }

}
// ! TC: O(N*2) ------- SC: O(1)

// selection sort ( Multiple Definations)
// 1 select smallest and swap
// 2 Iterate on array --- find minimum------ keep it on its correct position
// 3 find the smallest item in every iteration and replace with current index

// Selection sort in in place sorting algorithm
// Selection sort is Non - Stable sorting algorithm