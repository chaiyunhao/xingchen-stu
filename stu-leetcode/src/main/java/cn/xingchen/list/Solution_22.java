package cn.xingchen.list;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {

    public static void main(String[] args) {
        Solution_22 solution = new Solution_22();
        solution.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }

    private void helper(List<String> res, String sb, int left, int right){
        if(left == 0 && right == 0){
            res.add(sb.toString());
        }
        if(left > 0){
            helper(res, sb + "(", left - 1, right);
        }
        if(right > 0 && right > left){
            helper(res, sb + ")", left, right - 1);
        }
    }
}
