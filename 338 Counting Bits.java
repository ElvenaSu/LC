public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i>>1] + i%2;
        }
        return dp[num];
    }
}
