package cn.xingchen.list;

import java.util.ArrayList;
import java.util.List;

public class Solution_125 {

    public static void main(String[] args) {
        Solution_125 solution = new Solution_125();

        boolean res = solution.isPalindrome("0P");
        System.out.println(res);
        List<Integer> list = new ArrayList<>();
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(!isAbc(s.charAt(i)) && i < j){
                i++;
            }
            while(!isAbc(s.charAt(j)) && i < j){
                j--;
            }
            if(toUpper(s.charAt(i)) != toUpper(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAbc(char c){
        int k = (int)c;
        if((k >= 65 && k <= 90) || (k >= 97 && k <= 122)){
            return true;
        }
        return false;
    }

    private char toUpper(char c){
        int k = (int)c;
        if(k >= 97 && k <= 122){
            return (char) (k-32);
        }
        return c;
    }
}
