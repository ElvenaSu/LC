public class Solution {
    public void sortColors(int[] nums) {
        int len ＝ nums.length;
        int l = 0, r = len-1;
        //len长度一直在变化！！！
        for(int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            }
            while (nums[i] == 2 && i < len) {
                swap(nums, i, r);
                r--;
                len--;
                if (nums[i] == 0) {
                    swap(nums, i, l);
                    l++;
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
