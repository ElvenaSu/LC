public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = firstgreater(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1,-1};
        }
        return new int[]{start, firstgreater(nums, target+1)-1};
    }
    //could return nums.length if target is greater than nums[nums.length-1].
    public int firstgreater(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int mid = i + ((j-i)>>2);
            if (nums[mid] < target) {
                i = mid + 1;
            }else {
                //should not be mid-1 when nums[mid]==target.
				//could be mid even if nums[mid]>target
                //because target might missing.
                j = mid;
            }
        }
        return i;
    }
}
