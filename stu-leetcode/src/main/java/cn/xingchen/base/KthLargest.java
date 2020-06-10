package cn.xingchen.base;

import java.util.PriorityQueue;

public class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a){
        this.k = k;
        q = new PriorityQueue();
        for(int n : a){
            q.add(n);
        }
    }

    public int add(int n){
        if(q.size() < k){
            q.offer(n);
        }else if(q.peek() < n){
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
    }

}
