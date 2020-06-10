package cn.xingchen.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack();
        stack.pop();

        String s = "123";
        s.toCharArray();

    }

    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(inQueue.isEmpty()){
            throw new RuntimeException();
        }
        int res = 0;
        while (!inQueue.isEmpty()){
            res = inQueue.remove();
            if(!inQueue.isEmpty()){
                outQueue.add(res);
            }
        }
        while (!outQueue.isEmpty()){
            inQueue.add(outQueue.remove());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        if(inQueue.isEmpty()){
            throw new RuntimeException();
        }
        int res = 0;
        while (!inQueue.isEmpty()){
            res = inQueue.remove();
            outQueue.add(res);
        }
        while (!outQueue.isEmpty()){
            inQueue.add(outQueue.remove());
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}
