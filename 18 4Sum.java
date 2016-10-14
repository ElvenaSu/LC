public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i]*4 > target) {
                break;
            }
            if (nums[i] + 3*nums[nums.length-1] < target) {
                continue;
            }
            threeSum(nums, target, i, res);
        }
        return res;
    }
    public void threeSum(int[] nums, int target, int idx, List<List<Integer>> res) {
        for (int i = idx+1; i < nums.length-2; i++) {
            if (i > idx + 1 && nums[i] == nums[i-1]) {
                continue;
            }
            helper(nums, target, i, res, idx);
        }
    }
    private void helper(int[] nums, int target, int idx, List<List<Integer>> res, int idx2) {
        int i = idx+1, j = nums.length-1;
        while (i < j) {
            if (nums[i] + nums[j] + nums[idx] + nums[idx2]> target) {
                j--;
            }else if (nums[i] + nums[j] + nums[idx] + nums[idx2] < target) {
                i++;
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[idx]);
                tmp.add(nums[idx2]);
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
