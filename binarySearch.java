class binarySearch {

   public static void main(String[] args) {
      int[] a = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 14, 22, 54 };
      int k = 6;
      // search(a, 1);
      // localMinima(a);
      // System.out.println(peakElement(a));
      // System.out.println(lastOccurance(a, k));
      // System.out.println(firstOccurance(a, k));
      System.out.println(findCile(a, 15));
   }

   // pick start and end point
   // start by dividing array into half
   // if mid is equal to k then we have found
   // if mid > K then all the value to right of mid can be ignored
   // if mid < K then all values to left can be ignores
   // repeat untill we find value or loop ends

   static void search(int[] arr, int k) {
      int n = arr.length;
      int start = 0;
      int end = n - 1;

      while (start < end) {
         int mid = (start + end) / 2;

         if (mid == k) {
            System.out.println(true);
            return;
         }
         if (mid > k) {
            // ignore right
            // move left
            end = mid - 1;
         }
         if (mid < k) {
            // ignore left
            // move right
            start = mid + 1;
         }

      }
      System.out.println(false);
      return;
   }

   // Given unSorted Arr[N] distinct elements,return any local minma.
   // local minima is the index when both adjscent elements are smaller then
   // current

   static void localMinima(int[] arr) {
      // binary search
      // divide array in two halvs
      // decide which half will definetly have the minima and move towards that
      int n = arr.length;
      int start = 0;
      int end = n - 1;
      int ans = -1;

      while (start < end) {
         int mid = (start + end) / 2;

         // case1 : mid hi minima hai
         // case2 : mid k right side mai definetly minima hai
         // case3 : mid k left side mai minima hai
         // case4 : mid k kisi bi side chale jaao minima hai
         int midEl = arr[mid];
         int nextEl = arr[mid + 1];
         int prevEl = arr[mid - 1];

         if (midEl < nextEl && midEl < prevEl) {
            ans = midEl;
            break;
         } else if (nextEl < midEl && prevEl > midEl) {
            // definetly right side mai minima hai
            // ignore left
            // move right
            ans = midEl;
            start = mid + 1;
         } else if ((prevEl < midEl && nextEl > midEl) || (prevEl < midEl && nextEl < midEl)) {
            // definatle left mai minimai hai
            // ignore right
            // move left
            ans = midEl;
            end = mid - 1;
         }

      }

      System.out.println(ans);
   }

   // peak element
   static int peakElement(int[] A) {

      int n = A.length;

      int start = 0;
      int end = n - 1;
      int ans = 0;
      // edge cases
      if (n == 1) {
         ans = A[0];
         return ans;
      }
      if (A[start] > A[start + 1]) {
         ans = A[start];
         return ans;
      }
      if (A[end] > A[end - 1]) {
         ans = A[end];
         return ans;
      }
      while (start <= end) {
         int mid = (start + end) / 2;

         int midEl = A[mid];
         int nextEl = A[mid + 1];
         int prevEl = A[mid - 1];

         if (prevEl <= midEl && nextEl <= midEl) {
            ans = midEl;
            break;
         }
         if (nextEl > midEl) {
            // move right , ignore left
            ans = midEl;
            start = mid + 1;
         } else {
            // move left , ignore right
            ans = midEl;
            end = mid - 1;
         }
      }
      return ans;
   }

   // Given a sorted arr [ ] , Find the first occurence index of given element K

   static int firstOccurance(int[] A, int k) {
      int n = A.length;

      int start = 0;
      int end = n - 1;
      int ans = -1;

      while (start <= end) {
         int mid = (start + end) / 2;
         int midElement = A[mid];
         if (midElement == k) {
            ans = mid;
            end = mid - 1;
         } else if (midElement > k) {
            // ignore right
            // move left
            end = mid - 1;
         } else if (midElement < k) {
            // ignore left
            // move right
            start = mid + 1;
         }

      }
      return ans;
   }

   // Given a sorted arr[], Find the last occurence index of given element K
   static int lastOccurance(int[] A, int k) {
      int n = A.length;

      int start = 0;
      int end = n - 1;
      int ans = -1;

      while (start <= end) {
         int mid = (start + end) / 2;
         int midElement = A[mid];
         if (midElement == k) {
            ans = mid;
            start = mid + 1;
         } else if (midElement > k) {
            // ignore right
            // move left
            end = mid - 1;
         } else if (midElement < k) {
            // ignore left
            // move right
            start = mid + 1;
         }

      }
      return ans;
   }

   // "Given a sorted arrar[ ] , find the Cile of the given number K.
   // Cile = smallest element greater then or equal to K in array."

   static int findCile(int[] A, int K) {
      int n = A.length;
      int start = 0;
      int end = n - 1;
      int ans = -1;

      while (start <= end) {
         int mid = (start + end) / 2;

         if (A[mid] == K) {
            return A[mid];
         }
         if (A[mid] > K) {
            // ignore right
            // move left
            ans = A[mid];
            end = mid - 1;
         } else if (A[mid] < K) {
            start = mid + 1;
         }

      }
      return ans;

   }
}