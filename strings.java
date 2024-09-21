import java.util.*;

public class strings {

   public static void main(String[] args) {
      String str1 = "apple apple";
      String str2 = "banana";
      // System.out.print(isPalindrome(str1));
      System.out.print(Arrays.toString(uncommonFromSentences(str1, str2)));
   }

   static boolean isPalindrome(String s) {
      StringBuilder newStr = new StringBuilder();
      char[] str = s.toCharArray();

      for (int i = 0; i < str.length; i++) {
         char ch = str[i];
         System.out.println(ch);
         if (ch >= 48 && ch <= 57) {
            newStr.append(ch);
         }
         if (ch >= 97 && ch <= 122) {
            newStr.append(ch);
         }
         if (ch >= 65 && ch <= 90) {
            // convert to small case
            newStr.append((char) (ch + 32));
         }
      }

      String refinedStr = newStr.toString();
      System.out.println(refinedStr);
      char[] refinedStrArr = refinedStr.toCharArray();
      int n = refinedStrArr.length;
      // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
      // a m a n a p l a n a c a n a l p a n a m a
      // - - - - - - - - -

      if (n % 2 == 0) {
         System.out.println("center space mai hai");
         // center space mai hai
         int start = (n / 2) - 1;
         int end = (n / 2);
         if (n == 2) {
            start = 0;
            end = 1;
         }
         // loop and keep updating window
         while (start >= 0 && end <= n) {
            System.out.println("Start:" + start + " , " + "End:" + end);
            char ch1 = refinedStrArr[start];
            char ch2 = refinedStrArr[end];
            if (ch1 != ch2) {
               return false;
            }

            start--;
            end++;
         }
      } else {
         System.out.println("center number mai hai");
         // center n/2 + 1
         int start = (n / 2) - 1;
         int end = (n / 2) + 1;
         if (n == 2) {
            start = 0;
            end = 1;
         }
         while (start >= 0 && end <= n) {
            System.out.println("Start:" + start + " , " + "End:" + end);
            char ch1 = refinedStrArr[start];
            char ch2 = refinedStrArr[end];
            if (ch1 != ch2) {
               return false;
            }

            start--;
            end++;
         }
      }

      return true;
   }

   static String[] uncommonFromSentences(String s1, String s2) {

      List<String> ans = new ArrayList<>();
      // convert strings to array
      String[] s1arr = s1.split(" ");
      String[] s2arr = s2.split(" ");

      // crate hash map of frequency
      // {apple: 2 }
      // {banana:1 }
      HashMap<String, Integer> s1map = new HashMap<String, Integer>();
      HashMap<String, Integer> s2map = new HashMap<String, Integer>();

      for (int i = 0; i < s1arr.length; i++) {
         if (s1map.containsKey(s1arr[i])) {
            int val = s1map.get(s1arr[i]);
            s1map.put(s1arr[i], ++val);
         } else {
            s1map.put(s1arr[i], 1);
         }
      }
      for (int i = 0; i < s2arr.length; i++) {
         if (s2map.containsKey(s2arr[i])) {
            int val = s2map.get(s2arr[i]);
            s2map.put(s2arr[i], ++val);
         } else {
            s2map.put(s2arr[i], 1);
         }
      }
      // comparision
      // if freq == 1 && not exist in other array
      // push to answer

      for (String string : s1arr) {
         if (!s2map.containsKey(string)) {
            int freq = s1map.get(string);
            if (freq == 1) {
               // push to answer
               ans.add(string);
               // System.out.println(string);
            }
         }
      }

      for (String string : s2arr) {
         if (!s1map.containsKey(string)) {
            int freq = s2map.get(string);
            if (freq == 1) {
               // push to answer
               ans.add(string);
               // System.out.println(string);
            }
         }
      }
      String[] stringArray = ans.toArray(new String[0]);
      return stringArray;
   }
}