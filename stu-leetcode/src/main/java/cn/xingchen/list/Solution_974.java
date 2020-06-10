package cn.xingchen.list;

import java.util.*;

public class Solution_974 {

    public static void main(String[] args) {
        Solution_974 solution = new Solution_974();
        System.out.println(solution.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            System.out.print(modulus+ " ");
            int same = record.getOrDefault(modulus, 0);
            System.out.print(same +" ");
            System.out.println();
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public String[] uncommonFromSentences(String A, String B) {
        String[] aArrsy = A.split(" ");
        String[] bArray = B.split(" ");

        Map<String ,Integer> map = new HashMap<>();
        for(String s : aArrsy){
            map.put(s , map.getOrDefault(s, 0) + 1);
        }
        for(String s : bArray){
            map.put(s , map.getOrDefault(s, 0) + 1);
        }
        List<String> resList = new ArrayList<>();
        for(Map.Entry<String ,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                resList.add(entry.getKey());
            }
        }

        TreeMap<Integer, String> tree = new TreeMap<>();


        return resList.toArray(new String[resList.size()]);
    }
}
