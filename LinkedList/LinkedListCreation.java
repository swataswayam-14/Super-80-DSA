package LinkedList;

class Node {
    Node next;
    int data;

    Node(Node next1, int data1) {
        this.next = next1;
        this.data = data1;
    }
    Node (int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LinkedListCreation {

    public static void main(String[] args) {
        Node y = new Node(9);
        y.next = new Node(10);
        y.next.next = new Node(18);
        Node newHead = insertHead(100, y);
        printLL(newHead);
        System.out.println("The size of the LL is "+findLengthOfLL(newHead));
        System.out.println("Deleting the tail of the linkedList........");
        deleteTail(newHead);
        System.out.println("Updated LinkedList: ");
        printLL(newHead);
        System.out.println("The size of the LL is "+findLengthOfLL(newHead));
        System.out.println("Searching for 8 in the linkedList: "+isExists(8, newHead));
        System.out.println("Searching for 10 in the linkedList: "+isExists(10, newHead));
    }
    public static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node insertHead (int val, Node head) {
        Node newNode = new Node(head, val);
        return newNode;
    }
    //given a linkedList delete the tail of the linkedList and print the updated LinkedList
    public static int deleteTail(Node head) {
        if (head == null || head.next == null)
            return Integer.MIN_VALUE;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node deletedNode = temp.next;
        temp.next = null;
        return deletedNode.data;
    }
    public static int findLengthOfLL(Node head) {
        Node temp = head;
        int size = 0;
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public static boolean isExists(int val, Node head) {
        Node temp = head;
        while (temp != null) {
            if ( val == temp.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
