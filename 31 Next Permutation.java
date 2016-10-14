public class Solution {
    public void nextPermutation(int[] nums) {
        int first = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                first = i-1;
                break;
            }
        }
        if (first == -1) {
            Arrays.sort(nums);
        }else {
            for (int i = nums.length - 1; i > first; i--) {
                if (nums[i] > nums[first]) {
                    swap(i, first);
                    Arrays.sort(nums, first+1, nums.length);
                    break;
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
