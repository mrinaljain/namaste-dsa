import java.util.Scanner;

public class linkedlist {

   static class Node {
      int val;
      Node next;

      public Node(int val) {
         this.val = val;
      }

   }

   // function to add node
   static Node insert(Node head, int val, int idx) {
      // ! 1 create a new node
      Node newNode = new Node(val);
      if (idx == 0) {
         // ! 2 set addres of newNod to the address of head
         newNode.next = head;
         // ! 3 update the head of linkedlist as we are inserting at the begining
         head = newNode;
         return head;

      } else {

         // ! 2 idx k pehle vali node ko new node pr point karo
         Node temp = head;
         // finding idx-1 th node
         for (int i = 1; i <= idx - 1; i++) {
            temp = temp.next;
         }
         Node t1 = temp.next;
         temp.next = newNode;
         // ! 3 new node ko idx k baad vali pr point karo
         newNode.next = t1;
         return head;
      }

   }

   // print linked list
   static void print(Node head) {

      // loop untill you find node address to be null
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.val + " - ");
         temp = temp.next;
      }
      System.out.println();
   }

   // delete a node of linked list
   static Node delete(Node head, int idx) {
      Node temp = head;
      if (idx == 0) {
         head = head.next;
      } else {
         // finding idx-1 th node
         for (int i = 1; i <= idx - 1; i++) {
            temp = temp.next;
         }
         temp.next = temp.next.next;
      }
      return head;
   }

   // size of linked list
   static void size(Node head) {
      int length = 0;

      Node temp = head;
      while (temp != null) {

         length++;

         temp = temp.next;
      }
      System.out.println("Length of Linked List is " + length);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // ! creating a linked list
      int n = sc.nextInt();
      Node head = null;
      for (int i = 0; i < n; i++) {
         int val = sc.nextInt();
         head = insert(head, val, i);
      }
      // delete(head, 3);
      // print(head);
      size(head);
      sc.close();
   }
}
