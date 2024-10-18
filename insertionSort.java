import java.util.*;

class insertionSort {

   public static void main(String[] args) {
      System.out.println("Hello World..!");
      int[] a = { 10, 3, 6, 22, 8, 2, 5 };
      System.out.println(Arrays.toString(sort(a)));
   }

   static void swap(int[] ar, int a, int b) {
      int temp = ar[a];
      ar[a] = ar[b];
      ar[b] = temp;
   }

   static int[] sort(int[] arr) {
      // outer loop 0 -- n-1
      // inner loop
      int n = arr.length;
      for (int i = 1; i < n; i++) {
         // int start = 0;
         int end = i;
         while (end > 0) {
            if (arr[end - 1] > arr[end]) {
               swap(arr, end - 1, end);
            } else {
               break;
            }
            end--;
         }
      }

      return arr;
   }
}