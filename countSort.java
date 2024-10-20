import java.util.*;

class countSort {

   public static void main(String[] args) {
      int[] A = { 1, 5, 4, 9, 3, 3, 8, 5, 1, 6, 4, 5, 44, 5, 87, 4, 5, 55, 1 };

      sort(A);
   }

   // count sort
   // first store frequency of each element
   // / then loop through the count and print each frequency

   static void sort(int[] arr) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < arr.length; i++) {
         if (map.containsKey(arr[i])) {
            int freq = map.get(arr[i]);
            map.put(arr[i], ++freq);
         } else {
            map.put(arr[i], 1);
         }
      }
      // once hashmap is done now print based on hashmap
      // System.out.println(map);
      for (int i = 1; i <= 87; i++) {
         if (map.containsKey(i)) {
            int frequency = map.get(i);
            for (int j = 1; j <= frequency; j++) {
               System.out.print(i);
            }
         }
      }
      // System.out.println(arr);
   }
}

// Time Complexity : O(N + )