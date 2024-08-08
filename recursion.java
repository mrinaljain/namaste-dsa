public class recursion {
   public static void main(String[] args) {
      int n = 100;
      int i = 1;
      // naturalNumbers(n);
      naturalNumberDec(n);
      // System.out.println(fibonachi(n));
   }

   // ! Print N natural numbers using Recursion
   static void naturalNumbers(int N) {
      // breaking condition / smallest problem
      if (N == 1) {
         System.out.println(1);
         return;
      }
      // smaller problem
      naturalNumbers(N - 1);
      // what is the problem
      System.out.println(N);

   }

   // ! Print N natural numbers using Recursion in Decreasing order
   static void naturalNumberDec(int N) {
      // 5 4 3 2 1
      // breaking condition / smallest problem
      if (N == 1) {
         System.out.println(1);
         return;
      }

      System.out.println(N);
      // smaller problem
      naturalNumberDec(N - 1);
      // what is the problem

   }

   // Print SUM of N natural numbers using Recursion
   static int naturalSum(int N, int sum, int start) {
      sum = sum + start;
      if (start >= N) {
         return sum;
      }
      return naturalSum(N, sum, ++start);
   }

   // Print SUM of N natural numbers using Recursion
   static int sum(int N) {
      if (N == 1) {
         return 1;
      }
      int temp = sum(N - 1);
      return temp + N;
   }

   // factorial by recursion
   static int factorial(int n) {

      // 5! = 5 * factorial( n-1);
      // what is the problem ---> Find factorial

      // breaking condition
      if (n == 1) {
         return 1;
      }
      // smaller problem --->
      int temp = factorial(n - 1);
      return temp * n;
   }

   // fibonachi by recursion
   static int fibonachi(int n) {
      // print fibonachi serise for givrn number

      // fibona 00 01 01 02 03 05 08 13 21 34 55 89

      // Index 00 01 02 03 04 05 06 07 08 09 10 11 12
      // WHAT IS THE PROBLEM STATEMENT

      // breaking condition / smallest value
      if (n == 0 || n == 1) {
         return n;
      }

      // what is the smallest problem / sub problem
      int temp = fibonachi(n - 2) + fibonachi(n - 1);

      return temp;

   }
}
