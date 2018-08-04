package problems.p225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> values;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.values = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        values.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        final Queue<Integer> temps = new LinkedList<>();
        while (values.size() > 1) {
            temps.add(values.poll());
        }
        int top = values.poll();
        this.values = temps;
        return top;
    }

    /**
     * Get the top element.
     */
    public int top() {
        final Queue<Integer> temps = new LinkedList<>();
        while (values.size() > 1) {
            temps.add(values.poll());
        }
        int top = values.poll();
        temps.add(top);
        this.values = temps;
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return values.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */