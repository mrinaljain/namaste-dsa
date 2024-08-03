import java.util.Arrays;
public class prefixsum {
   public static void main(String[] args) {
      int[] arr = { 2, 1, 8, 3, 9, 6 };
      int B = 2;
      int[][] mat = { { 0, 3 }, { 3, 5 }, { 1, 3 }, { 2, 4 } };
      // solve(arr, 4);
      // rangeSum(arr, B);
      // equlibriumIndex(arr);
      // specialIndex(arr);
      // pickFromBothSides(arr, B);
      // inPlacePrefixSum(arr);
      evenInRange(arr, mat);
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

   // Equlibrium Index
   static void equlibriumIndex(int[] A) {

      // ! 1. Find prefix sum
      int n = A.length;
      int ans = n + 1;
      int[] ps = new int[n];
      ps[0] = A[0];
      for (int i = 1; i < n; i++) {
         ps[i] = A[i] + ps[i - 1];
      }
      // ! 2. Iterate over prefix sum array considering every index as equlibrium
      // ! index

      for (int center = 0; center < A.length; center++) {
         // calculating if( ps[0 , center-1] == ps[centre+1 , n-1]);
         // ps[0 , center-1] = ps[centre -1];
         // ps[centre+1 , n-1] = ps[n-1] - ps[centre+1 -1];
         int leftSum = 0;
         if (center == 0) {
            leftSum = 0;
         } else {
            leftSum = ps[center - 1];
         }
         int rightSum = ps[n - 1] - ps[center];
         if (leftSum == rightSum) {
            ans = Math.min(ans, center);
         }
      }

      // ! 3. print the answer
      if (ans > n) {
         System.out.println(-1);
      } else {
         System.out.println(ans);
      }
   }

   // Special Index
   static void specialIndex(int[] A) {

      // sum of even == sum of odd ???
      // sum[even left] + sum[even right] == sum[odd left] + sum[odd right]
      // ! after removing an index the right values will toggle
      // sum[even left] + sum[odd right] == sum[odd left] + sum[even right]

      // 1. construct 2 prefix sum now [ even , odd]
      int ans = 0;
      int n = A.length;
      int[] pse = new int[n];
      int[] pso = new int[n];
      pse[0] = A[0];
      // even prefix sum array
      for (int i = 1; i < n; i++) {
         if (i % 2 == 0) {
            pse[i] = A[i] + pse[i - 1];
         } else {
            pse[i] = pse[i - 1];
         }
      }
      pso[0] = 0;
      pso[1] = A[1];
      // odd prefix sum array
      for (int i = 2; i < n; i++) {
         if (i % 2 == 0) {
            pso[i] = pso[i - 1];
         } else {
            pso[i] = A[i] + pso[i - 1];
         }
      }

      System.out.println(Arrays.toString(pso));
      System.out.println(Arrays.toString(pse));
      // loop through entire orignal array considering every index as special
      // check if { sum[even left] + sum[odd right] == sum[odd left] + sum[even
      // right] }

      int sumEvenLeft = 0;
      int sumOddLeft = 0;
      int sumEvenRight = 0;
      int sumOddRight = 0;

      for (int i = 0; i < n; i++) {
         int end = n - 1;
         // ! 0 index check
         if (i == 0) {
            sumEvenLeft = 0;
            sumEvenRight = pse[end] - pse[i];
            sumOddRight = pso[end] - pso[i];
            sumOddLeft = 0;
         } else {
            sumEvenLeft = pse[i - 1];
            sumEvenRight = pse[end] - pse[i];
            sumOddRight = pso[end] - pso[i];
            sumOddLeft = pso[i - 1];
         }

         System.out.println(sumOddLeft);
         System.out.println(sumEvenLeft);
         System.out.println(sumOddRight);
         System.out.println(sumEvenRight);
         System.out.println("============");
         if (sumEvenLeft + sumOddRight == sumOddLeft + sumEvenRight) {
            ans++;
         }
      }

      System.out.println(ans);
   }

   // pickFromBothSides
   static void pickFromBothSides(int[] A, int B) {

      // !observation : Think of all posible combinations of removing elements from
      // front and back
      // loop through all posible combinations and find max from that
      int n = A.length;
      // prefix and suffix array
      int[] ps = new int[n];
      int[] ss = new int[n];
      ps[0] = A[0];
      ss[n - 1] = A[n - 1];

      for (int i = 1; i < n; i++) {
         ps[i] = A[i] + ps[i - 1];
      }

      for (int i = n - 2; i >= 0; i--) {
         ss[i] = A[i] + ss[i + 1];
      }
      System.out.println(Arrays.toString(ps));
      System.out.println(Arrays.toString(ss));
      int maxSum = Integer.MIN_VALUE;
      int i = 0;
      while (i <= B) {
         // prefix sum of 0,0 + suffix sum of last b elements
         int pSum = 0;
         int sSum = 0;
         if (i == 0) {
            pSum = 0;
            sSum = ss[n - B + i];
         } else {
            pSum = ps[i - 1];
            if (i == B) {
               sSum = 0;
            } else {
               sSum = ss[n - B + i];
            }
         }

         int sum = pSum + sSum;
         System.out.println(sum);
         maxSum = Math.max(maxSum, sum);
         i++;
      }
      System.out.println("========");
      System.out.println(maxSum);
   }

   // In place prefix sum
   static void inPlacePrefixSum(int[] A) {
      int n = A.length;
      // ! Approach 1
      // int ps = A[0];
      // for (int i = 1; i < n; i++) {
      // ps = ps + A[i];
      // A[i] = ps;
      // }
      // ! Approach 2
      for (int i = 1; i < n; i++) {
         A[i] += A[i - 1];
      }

      System.out.println(Arrays.toString(A));
   }

   // Even numbers in a range
   static void evenInRange(int[] A, int[][] mat) {
      int n = A.length;
      // ! 1.) create a evenPrefix array
      int[] psEven = new int[n];
      int evenCount = 0;
      for (int i = 0; i < n; i++) {
         if (A[i] % 2 == 0) {
            evenCount++;
         }
         psEven[i] = evenCount;
      }

      // ! 2.) Now loop through the given matrix of testcase to find any value
      int rows = mat.length;
      int[] ans = new int[rows];
      for (int r = 0; r < rows; r++) {
         if (mat[r][0] == 0) {
            ans[r] = psEven[mat[r][1]];
         } else {
            ans[r] = psEven[mat[r][1]] - psEven[mat[r][0] - 1];
         }

      }
      System.out.println(Arrays.toString(ans));
   }
}
