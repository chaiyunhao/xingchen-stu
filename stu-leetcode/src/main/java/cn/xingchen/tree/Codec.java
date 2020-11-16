package cn.xingchen.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public static void main(String[] args) {

        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,3,1,3,2,4]");
        System.out.println(codec.serialize(root));
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<TreeNode> list = new LinkedList();
        list.add(root);
        sb.append(root.val + ",");
        sequence(list, sb);
        sb.setLength(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    private void sequence(List<TreeNode> list, StringBuilder sb){
        List<TreeNode> subList = new LinkedList();
        for(TreeNode root : list){
            if(root.left != null) {
                sb.append(root.left.val + ",");
                subList.add(root.left);
            } else {
                sb.append("null,");
            }
            if(root.right != null) {
                sb.append(root.right.val + ",");
                subList.add(root.right);
            } else {
                sb.append("null,");
            }
        }
        if(subList.size() > 0) sequence(subList, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() < 3){
            return null;
        }
        List<String> list = new LinkedList<>(Arrays.asList(data.substring(1, data.length() - 1).split(",")));
        if(list.get(0) == null) return null;
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        resequence(nodeList, list);
        return root;
    }

    private void resequence(List<TreeNode> nodeList, List<String> list){
        List<TreeNode> subNodeList = new LinkedList<>();
        for(TreeNode root : nodeList){
            if(!list.isEmpty()) {
                if(!list.get(0).equals("null")) {
                    root.left = new TreeNode(Integer.valueOf(list.get(0)));
                    subNodeList.add(root.left);
                } else {
                    root.left = null;
                }
                list.remove(0);
            }

            if(!list.isEmpty()) {
                if(!list.get(0).equals("null")) {
                    root.right = new TreeNode(Integer.valueOf(list.get(0)));
                    subNodeList.add(root.right);
                } else {
                    root.right = null;
                }
                list.remove(0);
            }
        }
        if(subNodeList.size() > 0)resequence(subNodeList, list);
    }

}
