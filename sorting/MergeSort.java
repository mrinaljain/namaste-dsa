package sorting;

import java.util.Arrays;

public class MergeSort {
   public static void main(String[] args) {
      int[] arr1 = { 2, 8, 10, 14 };
      int[] arr2 = { 3, 7, 16, 20, 24 };

      int[] sortedArray = sort(arr1, arr2);
      System.out.println(Arrays.toString(sortedArray));
   }

   static int[] sort(int[] arrA, int[] arrB) {
      int n = arrA.length;
      int m = arrB.length;
      int[] ans = new int[m + n];
      int p1 = 0;
      int p2 = 0;
      int indexCounter = 0;
      // two pointer approach
      while (p1 < n && p2 < m) {
         if (arrA[p1] < arrB[p2]) {
            ans[indexCounter] = arrA[p1];
            p1++;
            indexCounter++;
         } else {
            ans[indexCounter] = arrB[p2];
            p2++;
            indexCounter++;
         }
      }

      // furthur 2 loops to send remaining elements to new merged array
      while (p1 < n) {
         ans[indexCounter] = arrA[p1];
         p1++;
         indexCounter++;
      }
      while (p2 < m) {
         ans[indexCounter] = arrB[p2];
         p2++;
         indexCounter++;
      }

      return ans;
   }
}

// Merge sort
// 2 pointer approach
