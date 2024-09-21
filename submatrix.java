import java.util.*;
public class submatrix {
   public static void main(String[] args) {
      int[][] mat = {
            { 5, 17, 100, 11 },
            { 0, 0, 2, 8 }
      };
      int[] b = { 1, 1 };
      int[] c = { 1, 4 };
      int[] d = { 2, 2 };
      int[] e = { 2, 4 };

      int[][] querry = {
            { 1, 1, 2, 2 }, // Sum submatrix from (1,1) to (2,2)
            { 0, 0, 1, 1 } // Sum submatrix from (0,0) to (1,1)
      };

      // submatrixSum(mat, querry);
      System.out.println(Arrays.toString(submatrixSumWithPrefixSum(mat, b, c, d, e)));

   }

   // submatrix
   // ! TC : O(N square)
   static void submatrixSum(int[][] mat, int[][] querry) {
      int n = querry.length;
      for (int i = 0; i < n; i++) {
         int x1 = querry[i][0];
         int y1 = querry[i][1];

         int x2 = querry[i][2];
         int y2 = querry[i][3];

         int submatrixsum = 0;
         for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
               submatrixsum += mat[row][col];
            }
         }

         System.out.println(submatrixsum);

      }
   }

   static int[] submatrixSumWithPrefixSum(
         int[][] A,
         int[] B,
         int[] C,
         int[] D,
         int[] E) {
      // Requirment: we need to calculate the sum of the submatrics formed by the
      // cordinates given in each querry
      // ! Intution: since we have multiple querries for SUM, here a Prefix sum matrix
      // will help
      // us answer N number of querries

      // Therefor the over all steps would be
      // STEP 1: Create a prefix sum matrix for given matrix
      // 1.1 => prefix sum of each row
      // 1.2 => prefix sum of each column

      // STEP:2 now loop over querries and find sum of desired querry
      // TopLeft =( B[i],C[i] )
      // BottomRight = (D[i], E[i])

      // 2.1 ==> find the Psum for bottomRight
      // ps[BottomRight]
      // 2.2 => substract the pSum of extra area
      // ps(D[i], E[i]) - ps()
      // STEP: 3 add each sum to an array

      // ? prestep create a copy of array to store long values also
      int row = A.length;
      int col = A[0].length;
      long[][] psum = new long[row][col];
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            psum[i][j] = A[i][j];
         }
      }

      // STEP 1: Create a prefix sum matrix for given matrix

      // 1.1 => prefix sum of each row
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            if (j != 0) {
               psum[i][j] += (psum[i][j - 1]) % 1000000007;
            }
         }
      }
      // 1.2 => prefix sum of each column
      for (int i = 0; i < col; i++) {
         for (int j = 0; j < row; j++) {
            if (j != 0) {
               psum[j][i] += (psum[j - 1][i]) % 1000000007;
            }
         }
      }
      // System.out.println(Arrays.toString(A));
      // STEP:2 now loop over querries and find sum of desired querry
      int querryLength = B.length; // basically we can take length of any array
      int[] ans = new int[querryLength];

      for (int i = 0; i < querryLength; i++) {
         long sum = 0;
         // considering TopLeft(x1, y1) & BottomRight(x2, y2)
         int x1 = B[i] - 1;
         int y1 = C[i] - 1;
         int x2 = D[i] - 1;
         int y2 = E[i] - 1;

         // 2.1 ==> find the Psum for bottomRight

         sum = psum[x2][y2];

         // 2.2 => substract the pSum of extra area areas
         if (y1 > 0) {
            sum -= psum[x2][y1 - 1];
         }
         if (x1 > 0) {
            sum -= psum[x1 - 1][y2];
         }
         if (x1 > 0 && y1 > 0) {
            sum += psum[x1 - 1][y1 - 1] % 1000000007;
         }
         ans[i] = (int) (sum % 1000000007);

         // IF ANS Is negative then add modulus again
         if (ans[i] < 0) {
            ans[i] += 1000000007;
         }
      }
      return ans;
   }
}
