public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -1*nums[i];
            helper(nums, target, i, res);
        }
        return res;
    }
    private void helper(int[] nums, int target, int idx, List<List<Integer>> res) {
        int i = idx+1, j = nums.length-1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            }else if (nums[i] + nums[j] < target) {
                i++;
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[idx]);
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                res.add(tmp);
                while(i < j && nums[i+1] == nums[i]) {
                    i++;
                }
                while(j > i && nums[j-1] == nums[j]) {
                    j--;
                }
                i++;
                j--;
            }
        }
    }
}
