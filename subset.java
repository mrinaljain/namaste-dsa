import java.util.Arrays;

public class subset {
   public static void main(String[] args) {
      int[] arr = { 3, 1, 4, 2, 6 };
      int B = 4;
      String str = "fsljkfsbfsjbgegbsebgjsgj";
      // System.out.println(subsetWithSumK(arr, B));
      // System.out.println(subsetSum(arr));
      // System.out.println(subsequenceMaxSum(arr))
      System.out.println(lexicographicallyMinSubSeq(str));
   }

   // lexicographically minimum subsequence of size>=2
   static String lexicographicallyMinSubSeq(String A) {
      StringBuffer str = new StringBuffer();
      int n = A.length() - 2;
      // loop from end to find the first character out of 2
      int firstIdx = n - 2;
      char first = A.charAt(firstIdx);
      while (n >= 0) {
         char ch = A.charAt(n);
         if (ch <= first) {
            first = ch;
            firstIdx = n;
         }
         n--;
      }
      str.append(A.charAt(firstIdx));

      // now we will run from first index to last because character before cannot be
      // part of sub sequence
      int secondIdx = firstIdx + 1;
      char second = A.charAt(secondIdx);
      for (int i = firstIdx + 1; i < A.length(); i++) {
         char ch = A.charAt(i);
         if (ch <= second) {
            second = ch;
            secondIdx = i;
         }
      }
      str.append(A.charAt(secondIdx));
      return str.toString();
   }

   // Subsequence Max Sum
   static int subsequenceMaxSum(int[] A) {
      int l = A.length;
      int iterator = l - 1;
      int maxSum = 0;
      int totalSubsequences = 1 << l;
      int contribution = totalSubsequences / 2; // half of the total no. of subsequences
      System.out.println("total subsequences : " + totalSubsequences);
      Arrays.sort(A);
      // while loop for looping from last
      // because contribution keeps getting half at each step
      while (iterator >= 0) {
         System.out.println(contribution + "*" + A[iterator]);
         maxSum = maxSum + (A[iterator] * contribution);
         // OR
         // maxSum = maxSum + (A[iterator] * (1 << iterator));

         contribution = contribution / 2;
         iterator--;
      }

      return maxSum;
      // ! TC = O(N logN)
   }

   // Subset sum using contribution technique
   static int subsetSum(int[] A) {
      int l = A.length;
      int n = 1 << l; // total no. of subsets possible is square of length
      int subsetSum = 0;
      int contribution = n / 2;
      for (int i = 0; i < l; i++) {
         subsetSum += A[i] * contribution;
      }
      return subsetSum;
   }

   // To check if ith bit of A is set OR unset
   static boolean checkBit(int A, int i) {
      // right shift A , i times to bring i to the right most
      // then do and with 1 to check the last value
      if (((A >> i) & 1) == 1) {
         return true;
      }
      return false;
   }

   // ! [1] Given an array( distincr elements) , find if there is any subset with
   // SUM = K
   static boolean subsetWithSumK(int[] A, int K) {
      int l = A.length;
      int n = 1 << l; // total no. of subsets possible is square of length

      // finding subsets using bit strategy
      // outer loop for looping over count of subsets
      for (int i = 0; i < n; i++) {
         int sum = 0; // for calculating sum of every subset
         // inner loop for iterating over bits of each number and deciding if subset.

         // looping from [0 to l-1] because length of each binary number will be equal to
         // length of array.
         for (int j = 0; j < l; j++) {
            // need to find ki [i] ka [j] th bit SET / UNSET hai kya
            // if set then add it if unset then ignore it
            boolean isSet = checkBit(i, j);
            if (isSet) {
               sum += A[j];
            }
         }
         // check if sum of this particular subset is equal to K
         if (sum == K) {
            return true;
         }

      }
      return false;
   }
}
