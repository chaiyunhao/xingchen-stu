package cn.xingchen.list;

/**
 * @author chaiyunhao
 * @create 2020-01-10 16:59
 */
public class Solution_55 {

    //----------------回溯--------start-----------
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int i){

        if(i == nums.length -1){
            return true;
        }

        int maxJump = Math.min(nums.length -1,i + nums[i]);
        for(int j = maxJump; j > i;j--){
            if(jump(nums, j)){
                return true;
            }
        }
        return false;
    }
    //----------------回溯--------end-----------

    public static void main(String[] args){
//        int[] a = {5,9,3,2,1,0,2,3,3,1,0,0};

        int[] a = {0};

        Solution_55 solution = new Solution_55();

        System.out.println(solution.canJump(a));

    }

}
