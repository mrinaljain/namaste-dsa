import java.lang.reflect.Array;
import java.util.Arrays;

public class hashing {
   public static void main(String[] args) {
      int[] arr = { -1, 8, 5, 3, 10, 2, 4, 9 };
      System.out.println(longestSequence(arr));
   }

   /*
    * Given arr[N] . Find the length of longest sequence which can be rearranged in
    * a strictly increasing order by 1.
    */
   static int longestSequence(int[] A) {
      int ans = 0;
      int length = A.length;
      int longestLength = 1;
      // sort
      Arrays.sort(A);
      // iterate from start and count length
      for (int i = 0; i < length - 1; i++) {
         // Increasing by 1 case
         if (A[i + 1] - A[i] == 1) {
            longestLength++;
            ans = Math.max(ans, longestLength);
         }
         // Equal case
         else if (A[i + 1] == A[i]) {
            // do nothing skip the iteration
            continue;
         } else {
            // reset the longestlength
            longestLength = 1;
         }
      }
      return ans;
   }
}
