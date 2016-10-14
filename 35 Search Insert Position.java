
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int i = 0, j = nums.length;
        while (i < j) {
            int mid = i + ((j-i)>>1);
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return i;
    }
}
