package cn.xingchen.dp;

public class Solution_309 {

    public static void main(String[] args) {
        Solution_309 solution = new Solution_309();
        System.out.println(solution.maxProfit(new int[]{1,2,3,0,2}));
    }

    public int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        int newF0 =0;
        int newF1 = 0;
        int newF2 = 0;
        for(int i = 0; i < prices.length; i++){
            newF0 = Math.max(f0, f2 - prices[i]);
            newF1 = f0 + prices[i];
            newF2 = Math.max(f1, f2);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }
        return Math.max(f1, f2);
    }


//    public int maxProfit(int[] prices) {
//
//        if(prices.length == 0){
//            return 0;
//        }
//
//        int dp0 = -prices[0];
//        int dp1 = 0;
//
//        int new0 = 0;
//        int new1 = 0;
//
//        for(int i = 0; i < prices.length; i++){
//            new0 = Math.max(dp0, dp1 - prices[i]);
//            new1 = Math.max(dp1, dp0 + prices[i]);
//            dp0 = new0;
//            dp1 = new1;
//        }
//
//        return Math.max(dp0, dp1);
//
//    }
}
