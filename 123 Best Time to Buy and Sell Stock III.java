Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the
stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int leftminbynow = prices[0], rightmaxbynow = prices[len-1];
        int leftprobynow = 0, rightprobynow = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < leftminbynow) {
                leftminbynow = prices[i];
            }
            leftprobynow = Math.max(prices[i] - leftminbynow, leftprobynow);
            left[i] = leftprobynow;
            if (prices[len-1-i] > rightmaxbynow) {
                rightmaxbynow = prices[len-1-i];
            }
            rightmaxbynow = Math.max(rightmaxbynow - prices[len-1-i], rightprobynow);
            right[len-1-i] = rightprobynow;
        }
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(left[i]+right[i], maxProfit);
        }
        return maxProfit;
    }
}
