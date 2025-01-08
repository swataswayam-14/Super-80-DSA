package StackQueue;

public class QueueUsingLinkedList {
    public int size;
    public Node front;
    public Node rear;
    public class Node {
        Node next;
        int data;
        Node(){
            this.data = 0;
            this.next = null;
        }
        Node (int x) {
            this.data = x;
            this.next = null;
        }
    }
    public QueueUsingLinkedList() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }
    public void Enqueue(int x) {
        Node node = new Node(x);
        if (front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;      
        }
        size++;
    }
    public int Dequeue() {
        if (size == 0 || front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int data = front.data;
        if (front == null) {
            rear = null;
        }
        front = front.next;
        size--;
        return data;
    }
    public int getSize() { 
        return size;
    }
    public boolean isEmpty() {
        return size == 0; 
    }
    public void peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
        } else {
            System.out.println("Element: " + front.data);
        }
    }
    public void printQueue() {
        if (front == null) {
            System.out.println("The queue is empty");
            return;
        }
        Node tempFront = front;
        while (tempFront != null) { 
            System.out.print(tempFront.data + " -> ");
            tempFront = tempFront.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.printQueue();
        queue.Dequeue();
        queue.printQueue();
        queue.Enqueue(100);
        queue.printQueue();
        queue.peek();
        System.out.println("Queue size: " + queue.getSize());
        queue.Dequeue();
        queue.Dequeue();
        queue.Dequeue();
        queue.printQueue();
    }
}
