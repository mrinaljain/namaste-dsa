public class carryforward {

   public static void main(String[] args) {
      String str = "ABCGAG";
      int[] A = { 377, 448, 173, 307, 108 };
      // specialSubSequence(str);
      closestMinMax(A);
   }

   // Special Subsequences "AG"
   static void specialSubSequence(String A) {

      int n = A.length();
      int count = 0;
      int MOD = 10 * 1000 * 1000 + 7;
      // ! Approach 1
      // loop through string --> as soon as find A --> start another loop to find
      // number of G
      // for (int i = 0; i < n; i++) {
      // char character = A.charAt(i);
      // if (character == 'A') {
      // for (int j = i + 1; j < n; j++) {
      // char ch = A.charAt(j);
      // if (ch == 'G') {
      // count++;
      // }
      // }
      // }
      // }

      // ! Approach 2
      // single loop if found a then increase count of 'A'
      // if found 'G' then increase count of ans as per 'A' count
      int countA = 0;
      for (int i = 0; i < n; i++) {
         char character = A.charAt(i);
         if (character == 'A') {
            countA++;
         }
         if (character == 'G') {
            count += countA;
            count %= MOD;
         }
      }
      System.out.println(count);
   }

   // Closest min-max subarray

   static void closestMinMax(int[] A) {
      int n = A.length;
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < n; i++) {
         if (A[i] > max) {
            max = A[i];
         }
         if (A[i] < min) {
            min = A[i];
         }
      }

      int minIndex = 0;
      int maxIndex = 0;
      int ans = Integer.MAX_VALUE;

      for (int i = 0; i < n; i++) {
         if (A[i] == min) {
            minIndex = i;
         }
         if (A[i] == max) {
            maxIndex = i;

            int distance = maxIndex - minIndex + 1;
            ans = Math.min(ans, distance);

         }

      }

      System.out.println(ans);
   }
}
