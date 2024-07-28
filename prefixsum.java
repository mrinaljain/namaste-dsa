import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.ranges.Range;

public class prefixsum {
   public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5 };
      int[][] B = { { 0, 3 }, { 1, 2 } };
      // solve(arr, 4);
      rangeSum(arr, B);
   }

   static void solve(int[] A, int B) {

      int n = A.length;
      int start = 0;
      int end = n - 1;
      int sum = 0;
      while (B > 0) {
         int s = A[start];
         int e = A[end];
         if (s >= e) {
            sum = sum + s;
            start++;
         } else {
            sum = sum + e;
            end--;
         }
         B--;
      }

      System.out.println(sum);
   }

   // Range Sum Query
   static void rangeSum(int[] A, int[][] B) {

      // create prefix sum
      int n = A.length;
      long[] ps = new long[n];

      ps[0] = A[0];

      for (int i = 1; i < n; i++) {
         ps[i] = A[i] + ps[i - 1];
      }

      // now we will find sum of range by looping on 2d array
      int r = B.length;
      int c = B[0].length;
      long[] ans = new long[r];
      int count = 0;
      for (int i = 0; i < r; i++) {
         int start = B[i][0];
         int end = B[i][1];
         long sumij = 0;
         if (start == 0) {
            sumij = ps[end];
         } else {
            sumij = ps[end] - ps[start - 1];
         }
         ans[count] = sumij;
         count++;
      }

      System.out.print(Arrays.toString(ans));
   }
}
