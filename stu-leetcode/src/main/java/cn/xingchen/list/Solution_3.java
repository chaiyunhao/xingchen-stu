package cn.xingchen.list;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        solution.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int N = s.length();
        int res = 0;
        int j = -1;
        set.add(s.charAt(0));
        for(int i = 0; i < N; i++){
            set.remove(s.charAt(i));
            while(j + 1 < N && !set.contains(s.charAt(j + 1))){
                set.add(s.charAt(++j));
            }
            res = Math.max(res, j - i);
            System.out.println("i = "+ i + " ,j = "+ j+ " ,res = " + res);
        }
        return res;
    }

}
