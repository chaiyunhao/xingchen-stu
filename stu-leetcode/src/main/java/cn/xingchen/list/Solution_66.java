package cn.xingchen.list;

/**
 * @author chaiyunhao
 * @create 2020-01-08 10:46
 */
public class Solution_66 {

    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;

        int[] temp = new int[]{0, 0};

        while (i >= 0) {
            if(i == digits.length - 1){
                temp = lastDigit(digits[i]);
            }else{
                temp = otherDigit(digits[i], temp[0]);
            }
            digits[i] = temp[1];
            i--;
        }

        if (temp[0] == 1) {
            int[] result = new int[digits.length + 1];

            for (int j = 0; j < result.length; j++) {
                if (j == 0) {
                    result[j] = 1;
                } else {
                    result[j] = digits[j - 1];
                }
            }
            return result;
        } else {
            return digits;
        }

    }

    private int[] lastDigit(int k){
        if(k == 9){
            return new int[]{1, 0};
        }else{
            return new int[]{0, k+1};
        }
    }

    private int[] otherDigit(int k, int c){
        k += c;
        if(k == 10){
            return new int[]{1, 0};
        }else{
            return new int[]{0, k};
        }
    }

    public int[] plusOne_1(int[] digits) {
        int temp = 0;
        int tmp = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if(i == digits.length - 1){
                tmp = digits[i] + 1;
            }else{
                tmp = digits[i] + temp;
            }
            digits[i] = tmp % 10;
            temp = tmp / 10;
        }

        if(temp > 0){
            //因为是 +1 所以只有在 9999 的情况才会溢出
            digits =  new int[digits.length + 1];
            digits[0] = temp;
        }
        return digits;
    }


    public static void main(String[] args) {

        int[] a = new int[]{1,2,3};

        Solution_66 solution = new Solution_66();
        int[] k = solution.plusOne(a);

        for (int j = 0; j < k.length; j++) {
            System.out.print(k[j]+"  ");
        }
        System.out.println();
    }
}
