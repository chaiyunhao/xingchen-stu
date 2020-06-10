package cn.xingchen.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        List<TreeNode> nodeList = new ArrayList();
        nodeList.add(root);
        helper(nodeList, res);
        return res;
    }

    private void helper(List<TreeNode> nodeList, List<List<Integer>> res){
        List<TreeNode> subList = new ArrayList();
        List<Integer> list = new ArrayList();
        for(TreeNode node : nodeList){
            list.add(node.val);
            if(node.left != null) subList.add(node.left);
            if(node.right != null) subList.add(node.right);
        }
        if(list.size() > 0)res.add(list);
        if(subList.size() > 0){
            helper(subList, res);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Map<Integer, List<Integer>> resMap = new HashMap();
        res.addAll(resMap.values());
        return res;
    }

    private void dfs(TreeNode node, int level, Map<Integer, List<Integer>> resMap){
        List<Integer> list = resMap.getOrDefault(level, new ArrayList());
        resMap.put(level, list);
        list.add(node.val);
        if(node.left != null) dfs(node.left, level + 1, resMap);
        if(node.right != null) dfs(node.right, level + 1, resMap);
    }

}
