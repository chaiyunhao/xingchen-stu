package cn.xingchen.sort;

public class TestBaseSort {
    public static void main(String[] args) {
        int[] nums = new int[]{10,14,73,25,23,13,27,94,33,39,25,59,94,65,82,45};
//        int[] nums = new int[]{10,14,73,25};
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        TestBaseSort sort = new TestBaseSort();
        sort.quickSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public void bubbleSort(int[] nums){
        int temp;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length - i; j++){
                if(nums[j-1] >  nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j > 0; j--){
                if(nums[j]<nums[j-1]){
                    swap(j, j-1, nums);
                }
            }
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void selectSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            swap(minIndex, i, nums);
        }
    }

    public void shellSort(int[] nums){
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0 ;i < gap; i++) {
                for (int j = i + gap; j < n; j += gap) {
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (nums[j] < nums[j - gap]) {
                        int tmp = nums[j];
                        int k = j - gap;
                        while (k >= 0 && nums[k] > tmp) {
                            nums[k + gap] = nums[k];
                            k -= gap;
                        }
                        nums[k + gap] = tmp;
                    }
                }
            }
        }

    }

    public void quickSort(int[] nums){
        helper(nums, 0, nums.length - 1);
    }
    private void helper(int[] nums, int low, int high){
        if(low > high) return;
        int i,j,k,temp;
        i = low;
        j = high;
        k = nums[low];
        while(i < j){
            while(nums[j] >= k && i < j){
                j--;
            }
            while(nums[i] <= k && i < j){
                i++;
            }
            if(i < j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = k;

        helper(nums, low, i - 1);
        helper(nums, i + 1, high);
    }

    public void mergeSort(int[] nums){
        int[] temp = new int[nums.length];
        helper(nums, 0, nums.length - 1, temp);
    }
    private void helper(int[] nums, int low, int high, int[] temp){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        helper(nums, low ,mid, temp);
        helper(nums, mid + 1 ,high, temp);
        merge(nums, low, mid, high, temp);
    }
    private void merge(int[] nums, int low, int mid, int high, int[] temp){
        int k1 = low;
        int k2 = mid + 1;
        int i = low;
        while(k1 <= mid && k2 <= high){
            temp[i++] = nums[k1] > nums[k2] ? nums[k2++] : nums[k1++];
        }
        while(k1 <= mid){
            temp[i++] = nums[k1++];
        }
        while(k2 <= high){
            temp[i++] = nums[k2++];
        }
        for(int m = low; m <= high; m++){
            nums[m] = temp[m];
        }
    }

    public void shellSort2(int[] nums){
       for(int gap = nums.length / 2; gap > 0; gap /= 2){
           for(int i = 0; i < gap; i++){
               for(int j = i + gap; j < nums.length; j += gap){
                   int m = j;
                   while(m > i){
                       if(nums[m] < nums[m - gap]){
                           swap(m, m - gap, nums);
                       }
                       m -= gap;
                   }
               }
           }
       }
    }

}
