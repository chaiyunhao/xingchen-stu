package cn.xingchen.list;

/**
 * @author chaiyunhao
 * @create 2019-12-31 17:23
 */
public class Solution_53 {

    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        if(nums.length <= 1){
            return sum;
        }

        int maxSub = sum;
        for(int i = 1; i < nums.length; i++){
            if(sum <= 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(sum > maxSub){
                maxSub = sum;
            }
        }

        return maxSub;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        Solution_53 solution = new Solution_53();

        System.out.println(solution.maxSubArray(nums));

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
