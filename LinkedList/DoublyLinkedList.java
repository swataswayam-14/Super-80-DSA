package LinkedList;

import java.util.Stack;

public class DoublyLinkedList {

    public static class Node  {

        int data;
        Node next;
        Node back;

        Node (int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }
        Node (int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }
    public static void main(String[] args) {
        Node y1 = new Node(1);
        Node y2 = new Node(2);
        Node y3 = new Node(3);
        Node y4 = new Node(4);
        Node y5 = new Node(5);
        y1.next = y2;
        y2.back = y1;
        y2.next = y3;
        y3.back = y2;
        y3.next = y4;
        y4.back = y3;
        y4.next = y5;
        y5.back = y4;

        System.out.println("Printing the LinkedList from front");
        printLLFront(y1);
        System.out.println("Printing the LinkedList from back");
        printLLBack(y5);
        System.out.println("Adding 100 to the linkedList.....");
        System.out.println("New LinkedList");
        insertNodeAtTail(y1, 100);
        printLLFront(y1);
        System.out.println("Deleting last node......");
        System.out.println("Updated LinkedList: ");
        deleteLastNode(y1);
        printLLFront(y1);
        System.out.println("Reversing DLL...");
        reverseBrute(y1);
        System.out.println("Printing it in forward direcn....");
        printLLFront(y1);
        reverseBrute(y1);
        System.out.println("Reversing DLL...");
        reverseOptimal(y1);
        printLLFront(y1);
    }
    public static void printLLFront(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void printLLBack(Node tail) {
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.back;
        }
        System.out.println();
    }

    public static Node insertNodeAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.back = current;
        newNode.next = null;
        return head;
    }
    public static Node deleteLastNode (Node head) {
        Node node = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head = null;
            return null;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        node.next.back = null;
        node.next = null;
        return head;
    }
    //reverse a doubly linked list : BRUTE FORCE
    public static Node reverseBrute (Node head) { //T.C is O(2n) and S.C is O(n)
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (!st.isEmpty() && temp != null) {
            int val = st.pop();
            temp.data = val;
            temp = temp.next;
        }
        return head;
    }
    private static Node reverseOptimal(Node head) {//T.C is O(n) and S.C is O(1)
        if (head == null || head.next == null) {
            return head; 
        }       
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
    }

}
