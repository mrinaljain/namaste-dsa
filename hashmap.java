import java.util.*;

public class hashmap {
   public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int B = 6;
      // frequency();
      // firstDistinct();
      // distinctElements();
      // subarrayZero();
      // largestSubarrayZeroSum();
      // distinctWindow(arr, B);
      // System.out.println(twoSumHashMap(arr, B));
      // System.out.println(twoSumHashSet(arr, B));
      // twoSumIndex(arr, B);
      subArraySumK(arr, B);
   }

   // Sub array with sum k
   static void subArraySumK(int[] A, int B) {
      int n = A.length;
      int start = 0;
      int end = 0;

      // create prefixsum
      int[] ps = new int[n];
      ps[0] = A[0];
      for (int i = 1; i < n; i++) {
         ps[i] = ps[i - 1] + A[i];
      }

      // create hashmap of prefix sum , index
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
         if (!map.containsKey(ps[i])) {
            map.put(ps[i], i);
         }
      }

      // loop throughprefix sum and find if b - ps[i] = B
      for (int i = 0; i < ps.length; i++) {
         int a = ps[i];
         int b = a + B;
         if (a == b) {
            if (map.containsKey(b)) {
               start = i + 1;
               end = map.get(b);
               break;
            }
         }
         if (a != b) {
            if (map.containsKey(b)) {
               start = i + 1;
               end = map.get(b);
               break;
            }
         }

      }
      System.out.println(start);
      System.out.println(end);
      if (start == 0 && end == 0) {
         int[] arr = new int[1];
         arr[0] = -1;
         System.out.println(Arrays.toString(arr));
         return;
      }
      int[] ans = new int[end - start + 1];
      int m = end - start + 1;
      for (int i = 0; i < m; i++) {
         ans[i] = A[start];
         start++;
      }
      // return ans;
      System.out.println(Arrays.toString(ans));
   }

   // Two sum find indexes
   static int[] twoSumIndex(int[] A, int K) {
      int n = A.length;
      int[] ans = new int[2];
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < n; i++) {
         int a = A[i];
         int b = K - a;
         if (map.containsKey(b)) {
            int value = map.get(b);
            ans[0] = value + 1;
            ans[1] = i + 1;
            System.out.println(Arrays.toString(ans));
            return ans;
         }

         if (!map.containsKey(a)) {
            map.put(a, i);
         }

      }

      return ans;
   }

   // Two Sum using hashmap
   static boolean twoSumHashMap(int[] A, int K) {
      // For sum of A[i] + A[j] to be equal to K
      // for A[i] there needs to ba an A[j] which is equal to A[i] - K
      // Just loop through array finding A[j] for every A[i]
      // Finding A[j] can be done via hashmap also
      int n = A.length;
      int[] ans = new int[2];
      // 1. create a frequency hashmap first
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
         // if value is already in map then increase the count
         if (map.containsKey(A[i])) {
            int value = map.get(A[i]);
            map.put(A[i], ++value);
         }
         // if value is not present then add new node in hashmap
         else {
            map.put(A[i], 1);
         }
      }
      // 2. loop through array and find if A[j] exists for A[i]

      for (int i = 0; i < n; i++) {
         int a = A[i];
         int b = K - a;

         if (a != b) {
            if (map.containsKey(b)) {
               return true;
            }
         }
         if (a == b) {
            if (map.containsKey(b)) {
               int val = map.get(b);
               if (val > 1) {
                  // yes exists
                  return true;
               }
            }
         }

      }
      return false;

   }

   // Two Sum using hashset
   static boolean twoSumHashSet(int[] A, int K) {
      // look left approach
      // at every step look left if b is present
      // also at every etep keep adding new element for upcoming step
      int n = A.length;
      int[] ans = new int[2];
      HashSet<Integer> set = new HashSet<>();

      for (int i = 0; i < n; i++) {
         int a = A[i];
         int b = K - a;

         if (set.contains(b)) {
            return true;
         }
         set.add(a);
      }
      return false;
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

   // Distinct Numbers in Window
   static void distinctWindow(int[] A, int B) {
      // find count of distinct numbers in every window of B elements

      // ! intution
      // lets use sliding window technique
      // in sliding window we will use same hashmap and keep adding and removing the
      // elements as we move along

      // find distinct elements in every window
      // for distinct elements we will use HAshmap to find distinct element
      int n = A.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      int[] ans = new int[n - B + 1];
      // hash map for first B elements
      for (int i = 0; i < B; i++) {
         if (map.containsKey(A[i])) {
            int value = map.get(A[i]);
            map.put(A[i], value + 1);
         } else {
            map.put(A[i], 1);
         }
      }

      // System.out.println(map.size());
      ans[0] = map.size();

      // now we will run loop using sliding window
      int s = 1;
      int e = B;

      while (e <= n - 1) {
         // remove first elements affect (s -1)
         // -> find the frequency --> reduce it by 1 --> set the value again
         int freq = map.get(A[s - 1]);
         freq--;
         map.put(A[s - 1], freq);
         // !extra check if freq becomes zero then remove the element itself
         if (freq == 0) {
            map.remove(A[s - 1]);
         }
         // add next elements affect (e)
         if (map.containsKey(A[e])) {
            int value = map.get(A[e]);
            map.put(A[e], value + 1);
         } else {
            map.put(A[e], 1);
         }
         // print the size in last
         // System.out.println(map.size());
         ans[s] = map.size();
         s++;
         e++;
      }
      System.out.println(Arrays.toString(ans));
   }


}
