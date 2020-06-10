package cn.xingchen.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaiyunhao
 * @create 2019-12-31 16:19
 */
public class Solution_48 {

    public void rotate(int[][] matrix) {

        Map<Integer,Integer> map = new HashMap();

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        Solution_48 solution_48 = new Solution_48();
        solution_48.rotate(matrix);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

}
