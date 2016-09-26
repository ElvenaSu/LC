public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return helper(dp, 1, n);
    }
    public int helper(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        dp[start][end] = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            dp[start][end] = Math.min(dp[start][end], i + Math.max(helper(dp, start, i-1), helper(dp, i+1, end)));
        }
        return dp[start][end];
    }
}
/*
这题要求我们在猜测数字y未知的情况下（1~n任意一个数），要我们在最坏情况下我们支付最少的钱。也就是说要考虑所有y的情况。
我们假定选择了一个错误的数x，（1<=x<=n && x!=y ）那么就知道接下来应该从[1,x-1 ] 或者[x+1,n]中进行查找。
假如我们已经解决了[1,x-1] 和 [x+1,n]计算问题，我们将其表示为solve(L,x-1) 和solve(x+1,n)，
那么我们应该选择max(solve(L,x-1),solve(x+1,n)) 这样就是求最坏情况下的损失。
总的损失就是 f(x) = x + max(solve(L,x-1),solve(x+1,n))
那么将x从1~n进行遍历，取使得 f(x) 达到最小，来确定最坏情况下最小的损失，也就是我们初始应该选择哪个数。
上面的说法其实是一个自顶向下的过程（Top-down），可以用递归来解决
*/
