package cn.xingchen.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {

    public static void main(String[] args) {
        Solution_105 solution = new Solution_105();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        Map<Integer, Integer> inMap = new HashMap();
        for(int i = 0; i < inLen; i++){
            inMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, 0, preLen - 1, inMap, 0, inLen - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int preLow, int preHigh,
                                 Map<Integer, Integer> inMap, int inLow, int inHigh){
        if(preLow > preHigh){
            return null;
        }
        int root =  preorder[preLow];
        int inIndex = inMap.get(root);

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = myBuildTree(preorder, preLow + 1, inIndex + preLow - inLow, inMap, inLow, inIndex - 1);
        rootNode.right = myBuildTree(preorder, inIndex + preLow - inLow + 1, preHigh, inMap, inIndex + 1, inHigh);

        return rootNode;
    }
}
