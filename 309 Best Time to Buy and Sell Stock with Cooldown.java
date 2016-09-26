public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] hold = new int[len];
        int[] nhold = new int[len];
        nhold[0] = 0;
        nhold[1] = Math.max(prices[1]-prices[0],0);
        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            nhold[i] = Math.max(hold[i-1] + prices[i], nhold[i-1]);
            hold[i] = Math.max(nhold[i-2] - prices[i], hold[i-1]);
        }
        return nhold[len-1];
    }
}
/*
引入辅助数组sells和buys

sells[i]表示在第i天不持有股票所能获得的最大累计收益
buys[i]表示在第i天持有股票所能获得的最大累计收益

初始化数组：
sells[0] = 0
sells[1] = max(0, prices[1] - prices[0])
buys[0] = -prices[0]
buys[1] = max(-prices[0], -prices[1])
状态转移方程：

sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
所求最大收益为sells[n-1]
*/
