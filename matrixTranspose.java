import java.util.Arrays;

public class matrixTranspose {
   public static void main(String[] args) {
      int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
      };
      System.out.println(Arrays.toString(transpose(matrix)));
   }

   static int[][] transpose(int[][] A) {
      int rows = A.length;
      int cols = A[0].length;
      int[][] transpose = new int[cols][rows];

      // iterate on one matrix and fill other matrix

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            transpose[j][i] = A[i][j];
         }
      }

      return transpose;
   }
}
