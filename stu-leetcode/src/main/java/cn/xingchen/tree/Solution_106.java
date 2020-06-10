package cn.xingchen.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution_106 {

    public static void main(String[] args) {
        Solution_106 solution = new Solution_106();
        solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap();
        int inLen = inorder.length;
        int postLen = postorder.length;

        for(int i = 0; i < inLen; i++){
            inMap.put(inorder[i], i);
        }

        return myBuildTree(postorder, 0, postLen - 1, inMap, 0, inLen - 1);

    }

    private TreeNode myBuildTree(int[] postorder, int postLow, int postHigh, Map<Integer, Integer> inMap, int inLow, int inHigh){
        if(postLow > postHigh){
            return null;
        }

        int root = postorder[postHigh];
        int inIndex = inMap.get(root);
        int leftTreeLen = inIndex - inLow;

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = myBuildTree(postorder, postLow, postLow + leftTreeLen, inMap, inLow, inIndex - 1);
        rootNode.right = myBuildTree(postorder, postLow + leftTreeLen + 1 , postHigh - 1, inMap, inIndex + 1, inHigh);

        return rootNode;
    }
}
