package cn.xingchen.test;

/**
 * @author chaiyunhao
 * @create 2020-01-09 15:35
 */
public class HashMapTest {


    public static void main(String[] args){

        String key = "1231";

        int h;

        System.out.println((h = key.hashCode()) ^ (h >>> 16));
        System.out.println(Integer.toBinaryString((h = key.hashCode()) ^ (h >>> 16)));
        System.out.println(Integer.toBinaryString(key.hashCode()));

    }

}
