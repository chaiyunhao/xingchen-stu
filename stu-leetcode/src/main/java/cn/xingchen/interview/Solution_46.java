package cn.xingchen.interview;

public class Solution_46 {

    public static void main(String[] args) {
        Solution_46 solution = new Solution_46();

        System.out.println(solution.translateNum(12258));

    }

    public int translateNum(int num) {
        String str = String.valueOf(num);

        return dfs(str, 0);
    }

    private int dfs(String str, int index){
        if (index >= str.length() - 1) return 1;
        int temp = Integer.valueOf(str.substring(index, index + 2));
        if(temp >= 10 && temp <= 25){
            return dfs(str, index + 1) + dfs(str, index + 2);
        }else{
            return dfs(str, index + 1);
        }
    }
}
