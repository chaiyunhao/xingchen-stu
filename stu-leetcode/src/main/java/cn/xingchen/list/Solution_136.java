package cn.xingchen.list;

import java.util.Arrays;

public class Solution_136 {

    public static void main(String[] args) {
        Solution_136 solution = new Solution_136();
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        solution.quickSort(nums, 0, nums.length - 1);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "  ");
        }
        System.out.println();

        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));

    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int temp;
        for(int i = 0; i < nums.length; i++){
            temp = k - nums[i];
            if(temp == 0){
                res +=1;
                continue;
            }
            int j = i + 1;
            while(j < nums.length){
                temp -= nums[j];
                if(temp == 0){
                    res +=1;
                    break;
                }
                j++;
            }
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums){
            res ^= i;
        }

        return res;
    }

    private void quickSort(int[] nums, int low, int high){
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int temp = nums[low];

        while(i < j){
            while (nums[j] >= temp && i < j){
                j--;
            }
            while(nums[i] <= temp && i < j){
                i++;
            }
            if(i < j){
                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);

    }
}
