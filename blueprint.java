public class blueprint {

   public static class Student {
      String name;
      int roll_no;
      int maths_marks;
      int dsa_marks;

      // constructor
      public Student(String name, int roll_no, int maths_marks, int dsa_marks) {
         this.name = name;
         this.roll_no = roll_no;
         this.maths_marks = maths_marks;
         this.dsa_marks = dsa_marks;
      }

      public void color_karo() {
         System.out.println(name);
      }
   }

   public static void main(String[] args) {

      Student s1 = new Student("Anjali", 20, 59, 22);
      s1.name = "Changed";
      // s1.roll_no = 20;
      // s1.maths_marks = 59;
      // s1.dsa_marks = 22;

      // System.out.println(s1.roll_no);

      Student s2 = s1;

      s2.roll_no = 30;

      // System.out.println(s1.roll_no);
      s1.color_karo();
   }
}
