package cn.xingchen.list;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.Stack;

public class Solution_169 {

    public static void main(String[] args) {
        Solution_169 solution = new Solution_169();
        int res = solution.majorityElement(new int[]{2,2,1,3,1,1,4,1,1,5,1,1,6});
        System.out.println(res);

        Stack<Character> stack = new Stack();
    }

    public int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        int k = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;

        int m = nums[0];
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                m = nums[i];
                n = 1;
            }else{
                if(nums[i] == m){
                    n++;
                }else{
                    m = nums[i];
                    n = 1;
                }
            }

            if(n >= k){
                return nums[i];
            }

        }
        throw new RuntimeException("not found");
    }

    private void quickSort(int[] nums, int low, int high){
        if(low > high){
            return;
        }
        int i, j, k, t;
        i = low;
        j = high;
        k = nums[low];
        while(i < j){
            while(nums[j] >= k && i < j){
                j--;
            }
            while(nums[i] <= k && i < j){
                i++;
            }
            if(i < j){
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = k;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
