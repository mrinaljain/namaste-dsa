public class spiralTraversal {

   public static void main(String[] args) {
      int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
      };

      // travers(matrix);
      generateMatrix(5);
   }

   static void travers(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      // mark all 4 ends of matrixrix

      int top = 0;
      int bottom = rows - 1;

      int left = 0;
      int right = cols - 1;

      while (top <= bottom && left <= right) {
         // visit top row
         for (int i = left; i <= right; i++) {
            System.out.println(matrix[top][i]);
         }
         top++;

         // visit right column
         for (int i = top; i <= bottom; i++) {
            System.out.println(matrix[i][right]);
         }
         right = right - 1;

         if (top <= bottom) {
            // visit bottom row
            for (int i = right; i >= left; i--) {
               System.out.println(matrix[bottom][i]);
            }
            bottom = bottom - 1;
         }

         if (left <= right) {
            // visit left column
            for (int i = bottom; i >= top; i--) {
               System.out.println(matrix[i][left]);
            }
            left = left + 1;
         }

      }

   }

   static void generateMatrix(int n) {
      int[][] matrix = new int[n][n];
      int rows = matrix.length;
      int cols = matrix[0].length;
      // mark all 4 ends of matrixrix

      int top = 0;
      int bottom = rows - 1;

      int left = 0;
      int right = cols - 1;
      int counter = 1;
      while (top <= bottom && left <= right) {
         // visit top row
         for (int i = left; i <= right; i++) {
            matrix[top][i] = counter++;
         }
         top++;

         // visit right column
         for (int i = top; i <= bottom; i++) {
            matrix[i][right] = counter++;
         }
         right = right - 1;

         if (top <= bottom) {
            // visit bottom row
            for (int i = right; i >= left; i--) {
               matrix[bottom][i] = counter++;

            }
            bottom = bottom - 1;
         }

         if (left <= right) {
            // visit left column
            for (int i = bottom; i >= top; i--) {
               matrix[i][left] = counter++;
            }
            left = left + 1;
         }
      }

   }
}
