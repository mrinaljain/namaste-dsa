public class squareroot {
   public static void main(String[] args) {

      findSquareRoot(25);
   }

   static int findSquareRoot(int N) {
      int start = 1;
      int end = N;
      int ans = 0;
      while (start <= end) {
         int mid = (start + end) / 2;
         // case 1 mid itself is squareroot
         if (mid * mid == N) {
            return mid;
         }
         if (mid > N) {
            // ignore right -> move left
            end = mid - 1;
         } else {
            // ignore left -> move right
            ans = mid;
            start = mid + 1;
         }
      }

      return ans;

   }
}
// Given N find the greatest i , Such that i*i<= N
