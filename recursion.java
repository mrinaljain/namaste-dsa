public class recursion {
   public static void main(String[] args) {
      int n = 2048;
      int i = 1;
      String str = "mrinal";
      char[] chArray = { 'm', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm', 'l' };
      // naturalNumbers(n);
      // naturalNumberDec(n);
      // System.out.println(fibonachi(n));

      // System.out.println(isPalindrom(chArray, 0, 8));

      // reverseString(str, str.length());
      // System.out.print(sumOfDigits(n));
      System.out.print(power(2, 5));
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

   // ! Print SUM of N natural numbers using Recursion
   static int naturalSum(int N, int sum, int start) {
      sum = sum + start;
      if (start >= N) {
         return sum;
      }
      return naturalSum(N, sum, ++start);
   }

   // ! Print SUM of N natural numbers using Recursion
   static int sum(int N) {
      if (N == 1) {
         return 1;
      }
      int temp = sum(N - 1);
      return temp + N;
   }

   // ! Factorial by recursion
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

   // ! Fibonachi by recursion
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

   // ! Check if the given substring is Palindrom?
   static boolean isPalindrom(char[] chArry, int start, int end) {

      // assumption --> Check if the given substring is Palindrom?

      // smallest problem/base condition
      if (chArry[start] != chArry[end]) {
         return false;
      }

      // sub problem which works
      if (start <= end) {
         return isPalindrom(chArry, ++start, --end);
      } else {
         return true;
      }

   }

   // ! Print reverse string using recursion
   static void reverseString(String str, int n) {

      // assumption --> the function will give a reversed string
      // base problem/ loop end case
      if (n == 0) {
         return;
      }

      // sub problem
      char ch = str.charAt(n - 1);
      System.out.print(ch);
      reverseString(str, --n);

   }

   // ! Sum of Digits of a number
   static int sumOfDigits(int n) {
      // assumption --> given a number find sum of all digts
      // base case / loop breaker
      if (n == 0) {
         return 0;
      }
      // sub problem
      int reminder = n % 10;
      n = n / 10;
      int temp = sumOfDigits(n);

      return temp + reminder;
   }

   // ! Given A and N find A raised to power N

   static int power(int A, int n) {
      // assumption
      // base problem/ deal breaker
      if (n == 1) {
         return A;
      }
      // sub problem
      int temp = power(A, n - 1);
      // return statement
      return temp * A;
   }
}
