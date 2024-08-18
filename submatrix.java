public class submatrix {
   public static void main(String[] args) {
      int[][] mat = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
      };

      int[][] querry = {
            { 1, 1, 2, 2 }, // Sum submatrix from (1,1) to (2,2)
            { 0, 0, 1, 1 } // Sum submatrix from (0,0) to (1,1)
      };

      submatrixSum(mat, querry);
   }

   // optimised submatrix prefix sum TODO
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
}
