package cn.xingchen.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {


    private static void getLeaf(Map<String, Integer> map, String k, JSONObject v){
        for(Map.Entry<String, Object> entry : v.entrySet()){
            String tempKey = k != null ? k+"."+entry.getKey() : entry.getKey();
            Object tempValue = entry.getValue();
            if(tempValue instanceof JSONObject){
                getLeaf(map, tempKey, (JSONObject)tempValue);
            }else{
                map.put(tempKey, (Integer) tempValue);
            }
        }
    }


    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        long N = n;
        return N > 0 ? recurrence(x, N) : 1.0/recurrence(x, -N);

    }

    private double recurrence(double x, long N){
        if(N == 1){
            return x;
        }
        System.out.println(N);
        double temp = recurrence(x, N / 2);
        return N % 2 == 0 ? temp * temp : temp * temp * x;

    }


    public static void main(String[] args) {
//        String str = "{ \"n\" : { \"k\" : 1, \"y\" : 2,\"d\" :{ \"a\" : 1, \"b\" :2 } }, \"b\" : 3}";
//        Map<String, Integer> map = new HashMap<>();
//        JSONObject jsonObject = JSON.parseObject(str);
//        getLeaf(map, null, jsonObject);
//        System.out.println(map);//{b=3, n.d.a=1, n.y=2, n.k=1, n.d.b=2}

        JsonTest test = new JsonTest();
        test.myPow(1, -2147483648);
    }
}
