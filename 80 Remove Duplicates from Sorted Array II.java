public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int slow = 1, fast = 1, count = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow++] = nums[fast];
                count=1;
            }else {
                if (count < 2) {
                    nums[slow++] = nums[fast];
                    count++;
                }
            }
            fast++;
        }
        return slow;
    }
}
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums
being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
