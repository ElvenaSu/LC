public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ranges;
        }
        int left = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            //long integers for test case: [-2147483648,-2147483647,2147483647]
            if ((long)nums[i+1] - nums[i] > 1) {
                if (nums[i] == left) {
                    ranges.add(""+left);
                }else {
                    ranges.add(left+"->"+nums[i]);
                }
                left = nums[i+1];
            }
        }
        if (left == nums[nums.length-1]) {
            ranges.add(""+left);
        }else{
            ranges.add(left+"->"+nums[nums.length-1]);
        }
        return ranges;
    }
}
