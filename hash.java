

import java.util.HashMap;
import java.util.Scanner;

public class hash {
   public static void main(String[] args) {
      HashMap<String , Integer> map = new HashMap<>();
      Scanner sc = new Scanner(System.in);

      int a = sc.nextInt();
      map.put("IND", 245);

      System.out.println(map);
      System.out.println(a);
      sc.close();
   }
}
