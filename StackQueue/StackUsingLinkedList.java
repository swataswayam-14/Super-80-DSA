package StackQueue;


public class StackUsingLinkedList {
    public Node head = null;
    public int size;
    public class Node {
        int data;
        Node next;
        Node() {
            this.data = 0;
            this.next = null;
        }
        Node (int x) {
            this.data = x;
            this.next = null;
        }
    }
    public void stackPush (int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        System.out.println("Element pushed");
        size++;
    }
    public int stackPop () {
        if (head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    public int stackSize() {
        return size;
    }
    public boolean stackIsEmpty() {
        return head == null;
    }
    public void printStack() {
        if (head == null) return;
        Node temp = head;
        for (int i = 0; i<= size; i++) {
            System.out.print((temp == null) ? "null" : (temp.data + "->"));
            if (temp != null) temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
       StackUsingLinkedList s = new StackUsingLinkedList();
        s.stackPush(10);
        s.stackPush(20);
        s.printStack();
        System.out.println("Element popped " + s.stackPop());
        System.out.println("Stack size: " + s.stackSize());
        System.out.println("Stack is empty or not: " + s.stackIsEmpty());
        s.printStack();
    }
}
