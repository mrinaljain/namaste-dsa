import java.util.Arrays;
import java.util.HashMap;

public class array {

   public static void main(String[] args) {
      int[] arr = { 1, 2, 1, 3, 4, 3 };
      int B = 3;
      // targetSum(arr, B);

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
