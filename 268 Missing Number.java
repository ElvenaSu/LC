public class Solution {
    public int missingNumber(int[] nums) {
        int[] help = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            help[nums[i]]++;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (help[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}

//SUM 法
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
