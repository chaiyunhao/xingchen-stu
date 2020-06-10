package cn.xingchen.list;

/**
 * @author chaiyunhao
 * @create 2020-01-09 08:58
 */
public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >= 0 || j >= 0){
            if(i >= 0 && j >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else if(i >= 0 && j >= 0 && nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else if(i < 0){
                nums1[k--] = nums2[j--];
            }else{
                nums1[k--] = nums1[i--];
            }
        }

    }

    public static void main(String[] args){

        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};


        Solution_88 solution = new Solution_88();
        solution.merge(a, 3, b, 3);

        for(int i = 0; i < 6; i++){
            System.out.print(a[i]+"  ");
        }

        System.out.println();
    }
}
