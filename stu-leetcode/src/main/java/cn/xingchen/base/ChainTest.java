package cn.xingchen.base;

public class ChainTest {

    public static void main(String[] args) {

    }

    static boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 上面的代码类似 hasCycle 函数
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode midCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 就在中间位置
        return slow;
    }

    static ListNode findLastK(ListNode head, int k){
        ListNode slow, fast;
        slow = fast = head;

        while (k > 0){
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static int[] twoSum(int[] nums, int target){
        int left = 0, right = nums.length-1;

        while (left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{left, right};
            }else if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }
        }
        return  new int[]{-1, -1};
    }

    static void reverse(int[] nums){
        int left = 0, right = nums.length-1;

        int temp;
        while (left < right){
            temp = nums[left];
            nums[++left] = nums[right];
            nums[--right] = temp;
        }

    }


}


