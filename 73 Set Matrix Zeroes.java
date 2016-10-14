public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean firstrow = false, firstcol = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && matrix[i][j] == 0) {
                    firstrow = true;
                }
                if (j == 0 && matrix[i][j] == 0) {
                    firstcol = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //这道题，这样做虽然AC了，但是如过firstrow or firstcol 为false，
        //那么是不是就错了？！！！！
        if (firstrow) {
            for(int j = 0; j < col; j++) {
            matrix[0][j] = 0;
            }
        }
        if (firstcol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
/*
*/
