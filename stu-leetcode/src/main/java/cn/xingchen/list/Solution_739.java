package cn.xingchen.list;

import java.util.*;

public class Solution_739 {
    public static void main(String[] args) {
        int[] T = new int[]{73,74,75,71,69,72,76,73};
        Solution_739 solution = new Solution_739();
        int[] res = solution.dailyTemperatures(T);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++){
            while(!stack.isEmpty() && T[stack.peekLast()] < T[i]){
                res[stack.peekLast()] = i - stack.peekLast();
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        while(!stack.isEmpty()){
            res[stack.pollLast()] = 0;
        }
        return res;
    }
}
