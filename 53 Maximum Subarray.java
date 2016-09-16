
public class Solution {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1] > 0? nums[i-1] : 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(nums[i], res);
        }
        return res == Integer.MIN_VALUE? 0 : res;
    }
}
