import java.util.Arrays;
public class prefixsum {
   public static void main(String[] args) {
      int[] arr = { -969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91,
            -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548,
            -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999,
            -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65,
            451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587 };
      int B = 81;
      int[][] C = { { 0, 3 }, { 1, 2 } };
      // solve(arr, 4);
      // rangeSum(arr, B);
      // equlibriumIndex(arr);
      // specialIndex(arr);
      pickFromBothSides(arr, B);
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
}
