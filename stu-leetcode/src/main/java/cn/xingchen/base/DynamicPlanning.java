package cn.xingchen.base;

public class DynamicPlanning {


    public static void main(String[] args) {

        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println(lis(a));

        System.out.println(bag( new int[]{2, 1, 3}, new int[]{4, 2, 3},4));
    }

    public static int lis(int[] nums){

        //初始化dp数组，默认值为1
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int bag(int[] wt, int[] val, int W){
        int N = wt.length;

        //初始化dp
        int[][] dp = new int[N+1][W+1];

        //背包重量为0，价值为0
        for(int i = 0; i <= N; i++){
            dp[i][0] = 0;
        }

        //物品重量为0，价值为0
        for(int i = 0; i <= W; i++){
            dp[0][W] = 0;
        }

        for(int j = 1; j <= W; j++){
            for(int i = 1; i <= N; i++){
                if(j - wt[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[N][W];
    }

    public static int bag(){
        int N = 3, W = 4;
        //重量
        int[] wt = {2, 1, 3};
        //价值
        int[] val = {4, 2, 3};

        //dp[i][w] i背包物品件数 w背包重量 dp[i][w]为当前价值
        int[][] dp = new int[N+1][W+1];
        //如果背包允许放入的重量为0，那么背包内物品价值肯定为0
        for(int i = 0; i <= N; i++){
            dp[i][0] = 0;
        }
        //如果没有物品，那么背包内物品价值肯定为0
        for(int j =0; j<=W; j++) {
            dp[0][j] = 0;
        }
        //外层为背包重量
        for(int j = 1; j <= W; j++){
            //内层为物品序号
            for(int i = 1; i <= N; i++){
                if(j - wt[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[N][W];

    }


}
