package cn.xingchen.stack;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

    private PriorityQueue<Integer> priorityQueue;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.priorityQueue = new PriorityQueue();
        this.stack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        priorityQueue.offer(x);
    }

    public void pop() {
        int res = stack.pop();
        priorityQueue.remove(res);
    }

    public int top() {
        int res = stack.pop();
        priorityQueue.remove(res);
        return res;
    }

    public int getMin() {
        int res = priorityQueue.poll();
        stack.removeElement(res);
        return res;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-1);
        minStack.top();
        minStack.getMin();
    }

}
