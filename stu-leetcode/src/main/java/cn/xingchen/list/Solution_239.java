package cn.xingchen.list;

import java.util.*;

public class Solution_239 {

    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 1, 2, 0, 5};
//        Solution_239 solution_239 = new Solution_239();
//        int[] res = solution_239.maxSlidingWindow(nums, 3);
//        for(int i : res){
//            System.out.print(i +" ");
//        }
//        System.out.println();

        quickSort(nums, 0, nums.length -1);

        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] nums, int start, int end){
        if(start > end){
            return;
        }
        int k = nums[end];
        int i = start;
        int j = end;
        while (i < j){
            while (nums[i] <= k && i < j){
                i++;
            }
            while (nums[j] >= k && i < j){
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[end] = nums[j];
        nums[j] = k;

        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

}
