

package sorting;

import java.util.Arrays;

public class BubbleSort {
   public static void main(String[] args) {
      int[] array = { 2, 8, 4, -1, 6, 7, 5, 10, -1 };
      int[] sortedArray = sort(array);
      System.out.println(Arrays.toString(sortedArray));
   }

   // Bubble sort
   static int[] sort(int[] arr) {
      // compare if a[i] > a[i+1] then swap (this will send the biggest element to end
      // of array)

      int n = arr.length;
      for (int i = 0; i < n; i++) {
         int swapCount = 0; // modification
         for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
               swap(arr, j, j + 1);
               swapCount++;
            }
         }
         if (swapCount == 0) // no swap happend , means already sort ho gya
            break;
      }
      return arr;
   }

   static void swap(int[] A, int x, int y) {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }
}

// ! Time Complexity = O(N*2)
// ! Space Complexity = O(1)

// Bubble Sort
// largest element bubbels up in every iteration
// Bubble sort is stable
