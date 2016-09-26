// O(n)解法
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int flag = 0, res = n;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                if (flag == 1) {
                    res--;
                }else {
                    flag = 1;
                }
            }else if (nums[i] < nums[i-1]) {
                //考虑到flag == 0的情况，故if else 的顺序不能乱，res--在前
                //flag = 0 和 flag ＝ 1 都是else的情况
                if (flag == -1) {
                    res--;
                }else {
                    flag = -1;
                }
            }else {
                res--;
            }
        }
        return res;
    }
}
// O(n2) 解法
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] sign = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j ++) {
                if (dp[i] < dp[j] + 1) {
                    if ( (nums[i] - nums[j])*sign[j] < 0 || (sign[j] == 0 && nums[i] != nums[j])) {
                        dp[i] = dp[j] + 1;
                        sign[i] = (nums[i] - nums[j]) > 0 ? 1 : -1;
                    }
                }
            }
        }
        int max = 2;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
