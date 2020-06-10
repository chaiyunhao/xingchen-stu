package cn.xingchen.list;

/**
 * @author chaiyunhao
 * @create 2019-12-31 16:48
 */
public class Solution_189 {

    public void rotate(int[] nums, int k) {

        if(k<=0){
            return;
        }
        k = k%nums.length;

        for(int m = 0; m < k; m++){
            int temp = nums[nums.length -1];
            for(int i = nums.length -1; i > 0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
    }

    public void rotate_2(int[] nums, int k) {

        if(k<=0){
            return;
        }
        k = k%nums.length;

        reversal(nums, 0, nums.length-1);
        reversal(nums, 0, k -1);
        reversal(nums, k, nums.length-1);
    }

    private void reversal(int[] nums, int i, int j){

        while(i < j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};

        Solution_189 solution = new Solution_189();
        solution.rotate_2(nums,3);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }

}
