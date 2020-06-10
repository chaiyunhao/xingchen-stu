package cn.xingchen.base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

public class SwapWindow {

    public static void main(String[] args){

        String s = "EBBANCF";
        String t = "AB";

        System.out.println(lengthOfLongestSubstring(s));

    }

    /**
     * 最小覆盖子串
     * 第一层 while 根据要寻找的子串的字符，先向右侧移动右游标，直到满足要求，
     * 第二层 while 首先将最小长度和之前记录比较，如果较小，则更新开始位置和最小长度，然后开始向右侧移动左游标，减小最小长度，
     * 直到不匹配，则回到第一层 while ，匹配后，再次进入第二层 while，如此循环，直到右游标越界
     * 那么在第二层 while 获得的开始位置和最小长度就是最终结果
     * @param s
     * @param t
     * @return
     */
    static String minWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        LinkedHashMap<Character, Integer> window = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> needs = new LinkedHashMap<>();

        char[] tChar = t.toCharArray();
        for(char c : tChar){
            needs.put(c, needs.getOrDefault(c,0) + 1);
        }


        int match = 0;

        char[] sChar = s.toCharArray();
        while (right < sChar.length) {
            char c1 = sChar[right];
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1,0) + 1);
                if(window.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    // 更新并且记录最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                char c2 = sChar[left];
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if(window.get(c2).intValue() < needs.get(c2).intValue()){
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ?
                "" : s.substring(start, start + minLen);
    }

    /**
     * 找到字符串中所有字母异位词
     * 第一层 while 根据要寻找的子串的字符，先向右侧移动右游标，现将字串全部覆盖，
     * 第二层 while 根据字串开始向右移动左游标，如果移动后，满足要求，则将左游标位置放入返回结果，回到第一层 while 继续寻找
     * 如果无法满足要求，则放弃，回到第一层 while 继续寻找
     * @param s
     * @param t
     * @return
     */
    static Vector<Integer> findAnagrams(String s, String t) {
        // 记录最短子串的开始位置和长度
        Vector<Integer> res = new Vector<>();
        int left = 0, right = 0;

        LinkedHashMap<Character, Integer> window = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> needs = new LinkedHashMap<>();

        char[] tChar = t.toCharArray();
        for(char c : tChar){
            needs.put(c, needs.getOrDefault(c,0) + 1);
        }


        int match = 0;

        char[] sChar = s.toCharArray();
        while (right < sChar.length) {
            char c1 = sChar[right];
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1,0) + 1);
                if(window.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left == tChar.length) {
                    res.add(left);
                }
                char c2 = sChar[left];
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if(window.get(c2).intValue() < needs.get(c2).intValue()){
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    static int lengthOfLongestSubstring(String str){
        int res = 0;
        int left = 0,right = 0;

        HashMap<Character, Integer> temp = new HashMap<>();

        while(right < str.length()){
            char s = str.charAt(right);
            temp.put(s, temp.getOrDefault(s, 0)+1);
            right++;
            while (temp.get(s) > 1){
                char t = str.charAt(left);
                temp.put(t, temp.getOrDefault(t, 0)-1);
                left++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

}
