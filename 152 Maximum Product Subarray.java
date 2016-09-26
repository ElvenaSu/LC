Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxdp = new int[len];
        int[] mindp = new int[len];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            //考虑到如过前一位是0，｛6，0，9，1｝这种情况需要抛弃前面从nums[i]开始，所以要和nums[i]比。
            maxdp[i] = Math.max(nums[i],Math.max(maxdp[i-1]*nums[i], mindp[i-1]*nums[i]));
            mindp[i] = Math.min(nums[i],Math.min(maxdp[i-1]*nums[i], mindp[i-1]*nums[i]));
            res = Math.max(maxdp[i], res);
        }
        return res;
    }
}
