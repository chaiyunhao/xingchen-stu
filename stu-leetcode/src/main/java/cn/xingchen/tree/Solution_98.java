package cn.xingchen.tree;

import java.util.*;

public class Solution_98 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);

        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);

        Solution_98 solution = new Solution_98();

        Queue<Integer> queue = new LinkedList();
        solution.inorderTraversal(node, queue);
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    private void inorderTraversal(TreeNode data, Queue<Integer> queue){
        if(data != null){
            inorderTraversal(data.left, queue);
            queue.offer(data.val);
            inorderTraversal(data.right, queue);
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, null, null);
    }


    private boolean helper(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if(min != null && min >= node.val ) return false;
        if(max != null && max <= node.val ) return false;
        //约束上下界，直到不满足条件，返回 false
        if(!helper(node.left, min, node.val)) return false;
        if(!helper(node.right, node.val, max)) return false;

        return true;
    }

    private boolean vlidate(TreeNode node){
        if(node == null) return true;
        if(node.left != null){
            int leftMax = getMax(node.left, node.left.val);
            if(node.val <= leftMax && node.left != null) return false;
        }
        if(node.right != null){
            int rightMin = getMin(node.right, node.right.val);
            if(node.val >= rightMin && node.right != null) return false;
        }
        return vlidate(node.left) && vlidate(node.right);
    }
    private int getMin(TreeNode node, int min){
        if(node == null){
            return min;
        }
        min = Math.min(node.val, min);
        return Math.min(getMin(node.left, min), getMin(node.right, min));
    }

    private int getMax(TreeNode node, int max){
        if(node == null){
            return max;
        }
        max = Math.max(node.val, max);
        return Math.max(getMax(node.left, max), getMax(node.right, max));
    }
}
