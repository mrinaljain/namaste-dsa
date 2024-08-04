import java.util.Arrays;
import java.util.HashMap;

public class array {

   public static void main(String[] args) {
      int[] arr = { 1, 2, 1, 3, 4, 3 };
      int B = 3;
      // targetSum(arr, B);
      distinctWindow(arr, B);
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
