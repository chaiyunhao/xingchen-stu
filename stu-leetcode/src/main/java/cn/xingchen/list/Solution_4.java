package cn.xingchen.list;

public class Solution_4 {

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length -1;
        int N2 = nums2.length -1;

        if(N1 < N2){
            int[] temp = nums1;nums1 = nums2;nums2 = temp;
            N1 = nums1.length - 1;N2 = nums2.length - 1;
        }

        int left = 0;int right = N1;
        while(left <= right){
            int i = (left + right)/2;
            int j = (N1 + N2)/2 - i;
            if(i < right && j > 0 && nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else if(i > left && i > 0 && nums1[i -1] > nums2[j]){
                right = i - 1;
            }else{
                int maxLeft = Math.max(nums1[i], nums2[j]);
                int maxRight;
                if(i == N1){
                    maxRight = nums2[j + 1];
                }else if(j == N2){
                    maxRight = nums1[i + 1];
                }else{
                    maxRight = Math.max(nums1[i + 1], nums2[j + 1]);
                }

                return 1.0 * (maxLeft + maxRight)/2;
            }
        }

        return 0.0;
    }

}
