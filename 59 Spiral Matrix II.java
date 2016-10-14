public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int idx = 1;
        int up = 0, right = n-1, bottom = n-1, left = 0;
        while (up <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                matrix[up][j] = idx++;
            }
            up++;

            for (int i = up; i <= bottom; i++) {
                matrix[i][right] = idx++;
            }
            right--;

            if ( up <= bottom){
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = idx++;
                }
            }
            bottom--;
            if(left <= right){
                for (int i = bottom; i >= up; i--) {
                    matrix[i][left] = idx++;
                }
            }
            left++;
        }
        return matrix;
    }
}
