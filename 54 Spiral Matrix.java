public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int up = 0, right = matrix[0].length-1, bottom = matrix.length-1, left = 0;
        while (up <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            up++;

            for (int i = up; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if ( up <= bottom){
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
            }
            bottom--;
            if(left <= right){
                for (int i = bottom; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }
}
