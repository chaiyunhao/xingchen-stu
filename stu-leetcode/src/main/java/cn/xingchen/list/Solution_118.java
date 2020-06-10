package cn.xingchen.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaiyunhao
 * @create 2019-12-31 16:19
 */
public class Solution_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>(i+1);
            for(int j = 0; j <= i; j++){
                if(i == j || j == 0){
                    list.add(1);
                }else{
                    if(i >= 2){
                        list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args){

        Solution_118 solution_48 = new Solution_118();
        List<List<Integer>> result = solution_48.generate(5);

        for(List<Integer> list : result){
            for(Integer i : list){
                System.out.print(i+"  ");
            }
            System.out.println();
        }

    }

}
