package cn.xingchen.list;

import java.util.*;

public class Solution_239_2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if(k * N == 0){
            return new int[0];
        }
        if(k == 1){
            return nums;
        }
        ArrayDeque<Integer> deque = new ArrayDeque();
        int[] res = new int[N - k + 1];
        for(int i = 0; i < k; i++){
            cleanupDeque(deque, nums, k, i);
        }
        res[0] = nums[deque.peekFirst()];
        for(int i = 0; i < k; i++){
            cleanupDeque(deque, nums, k, i);
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    private void cleanupDeque(ArrayDeque<Integer> deque, int[] nums, int k, int i){
        if(!deque.isEmpty() && deque.peekFirst() == i - k){
            deque.pollFirst();
        }
        if(deque.isEmpty()){
            deque.offerLast(i);
        }else{

            if(nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
                deque.offerLast(i);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution_239_2 solution_239 = new Solution_239_2();
        int[] res = solution_239.maxSlidingWindow(nums, 3);
        for(int i : res){
            System.out.print(i +" ");
        }
        System.out.println();
    }

}
