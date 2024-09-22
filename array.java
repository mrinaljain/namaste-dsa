import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Comparator;
public class array {

   public static void main(String[] args) {
      int[] arr = { 4, 2, -7, 3, 6, 9, 1, 8, 3, };
      int B = 3;
      int[][] intervals = {
            { 1, 5 },
            { 8, 10 },
            { 11, 14 },
            { 15, 20 },
            { 21, 24 },
      };
      int[] newInterval = { 12, 22 };

      // targetSum(arr, B);
      // System.out.println(largestNumber(arr));
      // System.out.println(firstMissingNaturanNumber(arr));
      mergeIntervals(intervals, newInterval);
   }

   static void mergeIntervals(int[][] intervals, int[] newInterval) {
      // ! Approach 1
      // The idea is to insert the given interval N at an appropriate place and then
      // print all the intervals(non-overlaping)

      // 1. Compare and check for every interval that can new interval is overlapping
      // or not.
      // 2.if not overlaping then print the smaller interval and move forward
      // ---- 2.1 if the non-overlapping prints the newupdated interval then we can
      // print
      // all the intervals after that as it is(because it is given that al intervals
      // are non overlapping)
      // 3.if overlapping then merge the 2 intervals and move forward

      int row = intervals.length;

      int s2 = newInterval[0];
      int e2 = newInterval[1];

      for (int i = 0; i < row; i++) {
         int s1 = intervals[i][0];
         int e1 = intervals[i][1];

         if (s2 > e1) {
            // non - overlapping case
            System.out.println(s1 + "," + e1);
         } else if (s1 > e2) {
            // non - overlapping case
            System.out.println(s2 + "," + e2);
            for (int j = i; j < row; j++) {
               System.out.println(intervals[j][0] + "," + intervals[j][1]);
            }
            return;
         } else {
            // overlapping case
            s2 = Math.min(s1, s2);
            e2 = Math.max(e1, e2);
         }

      }
      // edge case
      // if the code never went to else if condition then we need to print one last
      // value of else case s2, e2
      System.out.println(s2 + "," + e2);
   }

   static void swap(int[] ar, int a, int b) {
      int temp = ar[a];
      ar[a] = ar[b];
      ar[b] = temp;
   }

   static int firstMissingNaturanNumber(int[] A) {
      int n = A.length;
      // ! Approach 1: hashset approach
      // add all elements to hashset and run a loop from 1 to n , checking presence of
      // every number in set. ---> if number not found that is the Firstmissing
      // naturalnumber

      // HashSet<Integer> set = new HashSet<>();

      // for (int item : A) {
      // set.add(item);
      // }

      // for (int i = 1; i < n; i++) {
      // if (!set.contains(i)) {
      // return i;
      // }
      // }
      // return n + 1;
      // ------------------------------------

      // ! Approach 2: Bring number to correct index ( correct index = A[i] -1)
      // run loop on array and try to move every element to its correct position as
      // per sorted array
      // Conditions
      // if negative number then skip
      // if index is higher then skip
      // if 2 number are equal then skip
      // else swap

      int i = 0;
      while (i < n) {
         if (A[i] < 0 || A[i] > n || A[i] == i + 1) {
            i++;
         } else {
            if (A[i] < n && A[i] == A[A[i] - 1]) {
               i++;
            } else {
               // swap
               int correctIndex = A[i] - 1;
               swap(A, i, correctIndex);
            }

         }
      }

      for (int j = 0; j < n; j++) {

         if (A[j] != j + 1) {
            return j + 1;
         }
      }

      return n + 1;
   }

   static long getString(int m, int n) {

      // Convert the integers to strings

      String str1 = Integer.toString(m);

      String str2 = Integer.toString(n);

      // Concatenate the strings

      String mergedStr = str1 + str2;

      long mergedInt = Long.parseLong(mergedStr);

      return mergedInt;

   }

   static String largestNumber(int[] nums) {
      StringBuilder ans = new StringBuilder();
      int n = nums.length;
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
         arr[i] = nums[i];
      }
      // sorting using comparator

      Comparator<Integer> compa = new Comparator<Integer>() {

         @Override

         public int compare(Integer a, Integer b) {

            long onceA = getString(a, b);

            long onceB = getString(b, a);

            if (onceB > onceA) {

               return 1;

            } else if (onceB < onceA) {
               return -1;
            } else {

               return 0;

            }

         }

      };
      Arrays.sort(arr, compa);

      for (int i : arr) {
         ans.append(i);
      }

      return ans.toString();
   }

   // Target Sum
   static void targetSum(int[] A, int K) {

      int n = A.length;

      // ! Approach 1 TC: O(N²)
      // for (int i = 0; i < n; i++) {
      // for (int j = i + 1; j < n; j++) {
      // if (i != j && A[i] + A[j] == K) {
      // System.out.println("TRUE");
      // return;
      // }
      // }
      // }

      // ! Approach 2 using HASHMAP TC: O(N)
      // 1. Create a frequency hashmap
      // 2. if A[i] + A[j] == k then for A[i] there should exists a number in array
      // which if added to A[i] will make K;
      // 3. For every A[i] find if K -A[i] exists in array. (existance can be checked
      // using hashmap)

      // 1
      HashMap<Integer, Integer> hmap = new HashMap<>();
      for (int i = 0; i < n; i++) {
         int element = A[i];
         if (hmap.containsKey(element)) {
            int value = hmap.get(element);
            hmap.put(element, value++);
         } else {
            hmap.put(element, 1);
         }
      }

      for (int i = 0; i < n; i++) {
         int a = A[i], b = K - a;
         // 2
         if (hmap.containsKey(b)) {
            // ! Exception check if a == b then we need to check frequency of b to avoid
            // ! considering same element twice
            // 3
            if (a == b) {
               int value = hmap.get(b);
               if (value > 1) {
                  System.out.println("TRUE");
                  return;
               }
            } else {
               System.out.println("TRUE");
               return;
            }
         }

      }

      System.out.println("FALSE");
   }


}
