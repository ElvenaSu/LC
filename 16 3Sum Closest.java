
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int diff = helper(target, nums, i);
            if (diff == 0) {
                return target;
            }
            if (Math.abs(diff) < Math.abs(mindiff)) {
                mindiff = diff;
            }
        }
        return target - mindiff;
    }
    private int helper(int target, int[] nums, int idx) {
        int i = idx+1, j = nums.length-1;
        int diff = Integer.MAX_VALUE;
        while (i < j) {
            if (nums[i] + nums[j] + nums[idx] == target) {
                return 0;
            }else {
                if (Math.abs(nums[i] + nums[j] + nums[idx] - target) < Math.abs(diff)) {
                    diff = nums[i] + nums[j] + nums[idx] - target;
                }
                if (nums[i] + nums[j] + nums[idx] > target) {
                    j--;
                }else {
                    i++;
                }
            }
        }
        return diff;
    }
}
