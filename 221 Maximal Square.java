/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square
containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0'? 0 : 1;
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    continue;
                }
                int tmp = Math.min(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = Math.min(tmp, dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max*max;
    }
}
