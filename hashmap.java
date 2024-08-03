import java.util.*;

public class hashmap {
   public static void main(String[] args) {
      // frequency();
      // firstDistinct();
      // distinctElements();
      // subarrayZero();
      largestSubarrayZeroSum();
   }

   // find frequency of given element
   static void frequency() {
      int[] arr = { 2, 1, 2, 3, 1, 5, 4, 9, 11, 11, 11 };
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int freq = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i : arr) {
         if (map.containsKey(i)) {
            // update
            int value = map.get(i);
            map.put(i, ++value);
         } else {
            // create
            map.put(i, 1);
         }
      }
      // iteratr to get frequency
      freq = map.get(n);

      System.out.println("Frequency of " + n + " is: " + freq);
      sc.close();
   }

   // find the first distinct element in array
   static void firstDistinct() {
      int[] arr = { 4, 5, 9, 4, 3, 5, 4 };
      HashMap<Integer, Integer> map = new HashMap<>();
      // create a hashmap first
      for (int i : arr) {
         if (map.containsKey(i)) {
            // update
            int value = map.get(i);
            map.put(i, ++value);
         } else {
            // create
            map.put(i, 1);
         }
      }

      // again iterate on the array and pick the element with freq 1
      for (int i : arr) {
         int value = map.get(i);

         if (value == 1) {
            System.out.println(i);
            return;
         }
      }
   }

   // find total no. of distinct element
   static void distinctElements() {
      int[] arr = { 3, 9, 3, 4, 5, };
      // approach 1
      HashMap<Integer, Integer> map = new HashMap<>();
      // create a hashmap first
      for (int i : arr) {
         if (map.containsKey(i)) {
            // update
            int value = map.get(i);
            map.put(i, ++value);
         } else {
            // create
            map.put(i, 1);
         }
      }
      System.out.println("Number of distinct elements usinf hashmap: " + map.size());

      // approach 2
      HashSet<Integer> hset = new HashSet<>();
      // create a hashset first
      for (int i : arr) {
         hset.add(i);
      }
      System.out.println("Number of distinct elements usinf hashset: " + hset.size());
   }

   // SubArray with 0 sum
   static void subarrayZero() {
      int[] A = { 1, 2, -3 };
      int n = A.length;
      // create prefix sum
      int[] prefix = new int[n];
      prefix[0] = A[0];
      for (int i = 1; i < n; i++) {
         prefix[i] = A[i] + prefix[i - 1];
      }
      System.out.println(Arrays.toString(prefix));

      // now check if there is any repetability in array
      HashSet<Integer> hset = new HashSet<>();
      for (int i = 0; i < prefix.length; i++) {
         if (prefix[i] == 0) {
            System.out.println("contains a sub-array with sum");
            return;
         }
         hset.add(prefix[i]);
      }

      if (prefix.length == hset.size()) {
         System.out.println("NO doesnot contains a sub-array with sum");
         return;
      }
      System.out.println("contains a sub-array with sum");
   }

   // Largest Continuous Sequence Zero Sum
   static void largestSubarrayZeroSum() {
      int[] arr = { -19, 8, 2, -8, 19, 5, -2, -23 };
      int longest = 0;
      int start = 0;
      int end = 0;
      // create prefixsum
      int n = arr.length;
      int[] ps = new int[n];
      ps[0] = arr[0];

      for (int i = 1; i < n; i++) {
         ps[i] = arr[i] + ps[i - 1];
         // add ps[i] check here
         if (ps[i] == 0) {
            int length = i + 1;
            if (length > longest) {
               longest = length;
               start = 0;
               end = i;
            }
         }
      }
      // approach 1
      // for (int i = 0; i < n; i++) {
      // for (int j = i + 1; j < n; j++) {
      // if (ps[i] == ps[j]) {
      // int length = j - i + 1;
      // if (length > longest) {
      // longest = length;
      // start = i + 1;
      // end = j;
      // }
      // }
      // }
      // }

      // approach 2
      // iterate through the prefix sum array to create hash map
      HashMap<Integer, Integer> freq = new HashMap<>();
      for (int i : ps) {
         if (freq.containsKey(i)) {
            // update
            int value = freq.get(i);
            freq.put(i, ++value);
         } else {
            // create
            freq.put(i, 1);
         }
      }

      // print the sub array
      int subarraylength = end - start + 1;
      int[] subarray = new int[subarraylength];
      if (end == 0) {
         subarray[0] = 0;
      } else {
         for (int i = 0; i < subarraylength; i++) {
            subarray[i] = arr[start];
            start++;
         }
      }

      System.out.println(Arrays.toString(subarray));
   }
}