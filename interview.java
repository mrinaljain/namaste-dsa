import java.util.Arrays;

public class interview {

   public static void main(String[] args) {
      int[] arr = { 5, 6, 7, -3, 2, -10, -12, 8, 12, 21, -4, 7 };
      // System.out.println(rainWatertrapped(arr));
      // System.out.println(maxSumSubarray(arr));
      System.out.println(maxSumSubarrayOptimised(arr));
   }

   // Find the maximum sum of contiguous non-empty subarray within an array A of
   // length N.
   // ! TC: O(n * square)
   static int maxSumSubarray(int[] A) {
      int n = A.length;
      int maxSum = Integer.MIN_VALUE;
      // make prefix sum
      int[] ps = new int[n];
      ps[0] = A[0];
      for (int i = 1; i < n; i++) {
         ps[i] = ps[i - 1] + A[i];
      }

      // now loop over all possible sub array and find there sum via sub array
      // pick max from them
      // note: this is O(n * square) approach

      // outer loop for subarray starting point
      for (int start = 0; start < n; start++) {
         // inner loop for subarray ending point
         for (int end = start; end < n; end++) {
            int sum = 0;
            if (start == 0) {
               sum = ps[end];
            } else {
               sum = ps[end] - ps[start - 1];
            }
            if (sum > maxSum) {
               maxSum = sum;
            }
         }
      }

      return maxSum;
   }

   // ! TC: O(n )
   static int maxSumSubarrayOptimised(int[] A) {
      int n = A.length;
      int maxSum = Integer.MIN_VALUE;
      int currentSum = 0;
      int start = 0;
      int end = 0;
      for (int i = 0; i < n; i++) {
         currentSum = currentSum + A[i];

         if (currentSum > maxSum) {
            maxSum = currentSum;
            end = i;
         }

         if (currentSum < 0) {
            currentSum = 0;
            start = i + 1;
            end = i + 1;
         }

      }
      System.out.println("[" + start + " , " + end + "]");
      return maxSum;
   }

   // 217
   // Given Array on N elements, where arr[i] represents the height of building.
   // return the amount of water trapped in all the buildings.
   // Note: width of each building is 1
   static int rainWatertrapped(int[] buildings) {
      int n = buildings.length;
      int totalWater = 0;
      int[] preMax = new int[n];
      int[] sufMax = new int[n];
      int currentMax = Integer.MIN_VALUE;
      // build prefixmax
      // A [ i ] = MAX of values from [ 0 , i ]
      for (int i = 0; i < n; i++) {
         if (buildings[i] > currentMax) {
            currentMax = buildings[i];
         }
         preMax[i] = currentMax;

      }
      System.out.println(Arrays.toString(preMax));
      // build suffix max
      // A [ i ] = MAX of values from [ i , n-1 ]
      currentMax = Integer.MIN_VALUE;
      for (int i = n - 1; i >= 0; i--) {
         if (buildings[i] > currentMax) {
            currentMax = buildings[i];
         }
         sufMax[i] = currentMax;
      }
      System.out.println(Arrays.toString(sufMax));
      // final calculation
      for (int i = 0; i < n; i++) {
         int heightOfBuilding = buildings[i];
         int rMax = sufMax[i];
         int lMax = preMax[i];

         int waterOnTop = Math.min(rMax, lMax);
         totalWater = totalWater + (waterOnTop - heightOfBuilding);
      }
      return totalWater;
   }
}
