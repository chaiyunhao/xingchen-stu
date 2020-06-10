package cn.xingchen.base;

import java.util.*;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tree;
        if(map.get(key) == null){
            tree = new TreeMap<>();
        }else{
            tree = map.get(key);
        }

        tree.put(timestamp, value);
        map.put(key ,tree);
    }

    public String get(String key, int timestamp) {
        if(map.get(key) == null) return "";
        TreeMap<Integer, String> tree = map.get(key);
        if(tree.get(timestamp) != null) return tree.get(timestamp);
        Integer treeKey = tree.floorKey(timestamp);
        if(treeKey == null) return "";
        return tree.get(treeKey);
    }

    public static void main(String[] args) {
        //[[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
        TimeMap timeMap = new TimeMap();
        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        System.out.println(timeMap.get("love",5));
        System.out.println(timeMap.get("love",10));
        System.out.println(timeMap.get("love",15));
        System.out.println(timeMap.get("love",20));
        System.out.println(timeMap.get("love",25));

        StringBuffer sb = new StringBuffer();
        sb.append("1");
        List<String> res = new ArrayList<>();
        res.add(sb.toString());
    }
}
