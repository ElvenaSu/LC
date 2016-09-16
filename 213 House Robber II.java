public class Solution {
    public int rob(int[] nums) {
        int[] robfirst = new int[nums.length];
        int[] skipfirst = new int[nums.length];
        robfirst[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                robfirst[i] = Math.max(nums[1], nums[0]);
                skipfirst[i] = nums[1];
            }
            robfirst[i] = Math.max(robfirst[i-1], robfirst[i-2] + nums[i]);
            skipfirst[i] = Math.max(skipfirst[i-1], skipfirst[i-2] + nums[i]);
        }
        return Math.max(robfirst[nums.length-2], skipfirst[nums.length-1]);
    }
}
