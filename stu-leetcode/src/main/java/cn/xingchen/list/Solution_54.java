package cn.xingchen.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaiyunhao
 * @create 2020-01-03 14:54
 */
public class Solution_54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int M = m*n;

        int k = 0;
        int j = 0;

        for(int i = 0; i < M; i++){
            result.add(matrix[k][j]);


        }


        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{10,11,12}};

        Solution_54 solution = new Solution_54();
        solution.spiralOrder(matrix);

    }
}
