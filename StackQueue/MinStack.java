package StackQueue;

import java.util.Stack;

public class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack <> ();
    }
    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        }else {
            min = Math.min(x, st.peek().y);
        }
        st.push(new Pair(x,min));
    }
    public void pop(){
        st.pop();
    }
    public int top(){
        return st.peek().x;
    }
    public int getMin() {
        return st.peek().y;
    }

}
class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
