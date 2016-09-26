//http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        if (k >= len) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                res += prices[i] - prices[i-1] > 0 ? prices[i] - prices[i-1] : 0;
            }
            return res;
        }
        int[][] local = new int[len][k+1];
        int[][] global = new int[len][k+1];
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(local[i-1][j] + diff, global[i-1][j-1]);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[len-1][k];
    }
}
