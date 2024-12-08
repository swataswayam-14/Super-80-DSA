package StackQueue;

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("push 0");
        System.out.println("push 1");
        System.out.println("push 3");
        q.push(0);
        q.push(1);
        q.push(3);
        System.out.println("POP: "+q.pop());
        System.out.println("POP: "+q.pop());
        System.out.println("POP: "+q.pop());
        System.out.println("POP: "+q.pop());
        System.out.println("push 0");
        q.push(0);
        System.out.println("POP: "+q.pop());
    }
}
class Queue {
    int start = -1;
    int end = -1;
    int size = 10000;
    int arr[] = new int[size];
    int currSize = 0;

    void push(int x) {
        if (this.start == -1 && this.end == -1) {
            this.start = this.end = 0;
            this.arr[this.end] = x;
        } else if (this.currSize == size) {
            System.out.println("Size is full and elements cannot be inserted into the Queue");
        } else {
            this.end += 1;
            this.arr[this.end] = x;
        }
        this.currSize += 1;
    }
    int pop() {
        if (this.start == -1 && this.end == -1) {
            System.out.println("There are no elements currently in the queue");
            return Integer.MIN_VALUE;
        } else if( currSize == 1) {
            int el = this.arr[this.start];
            this.start = this.end = -1;
            return el;
        }
        int el = this.arr[this.start];
        this.start = (this.start + 1) % this.size;
        this.currSize -= 1;
        return el;
    }
    int top() {
        if (start == -1) {
            return Integer.MIN_VALUE;
        }
        return this.arr[this.start];
    }
    int size (){
        return this.currSize;
    }
}
