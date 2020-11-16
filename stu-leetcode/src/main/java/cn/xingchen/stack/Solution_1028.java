package cn.xingchen.stack;

import cn.xingchen.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1028 {

    public static void main(String[] args) {

        int a = '0'-'0';
        System.out.println(a);

        Solution_1028 solution = new Solution_1028();
        solution.recoverFromPreorder("1-401--349---90--88");

    }

    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0 || !Character.isDigit(S.charAt(0))){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        int level = 0;
        int value = 0;

        int i = 0;
        while(i < S.length()){
            while(i < S.length() && S.charAt(i) == '-'){
                level++;
                i++;
            }
            while(i < S.length() && Character.isDigit(S.charAt(i))){
                int key = S.charAt(i) - '0';
                value = value * 10 + key;
                System.out.println("i = "+ i +", key = "+ key+", value = " +value);
                i++;
            }
            TreeNode node = new TreeNode(value);
            if(stack.isEmpty()){
                stack.offerLast(node);
            }else if(stack.size() == level){
                stack.peekLast().left = node;
                stack.offerLast(node);
            }else{
                while(stack.size() > level){
                    stack.pollLast();
                }
                stack.peekLast().right = node;
                stack.offerLast(node);
            }
            value = 0;
            level = 0;
        }
        if(stack.isEmpty()){
            return null;
        }
        if(stack.size() > 1){
            stack.pollLast();
        }
        return stack.pollLast();
    }
}
