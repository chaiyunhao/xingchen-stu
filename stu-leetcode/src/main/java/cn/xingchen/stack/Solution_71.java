package cn.xingchen.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_71 {
    public static void main(String[] args) {
        Solution_71 solution = new Solution_71();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] pathArray = path.split("/");
        for(String str : pathArray){
            if(str.equals("..")){
                if(!stack.isEmpty()) {
                    stack.pollLast();
                }
            }else if(!str.equals(".") && !str.equals("")){
                stack.offerLast(str);
            }
        }

        StringBuilder res = new StringBuilder();
        for(String str : stack){
            res.append("/" + str);
        }
        return res.toString();
    }
}
