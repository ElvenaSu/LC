//Don't treat it as a 2D matrix, just treat it as a sorted list
//这道题用sorted list 的角度做会更快更简洁一些！！！
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = row;
        while (i < j) {
            int mid = i + ((j-i)>>1);
            //System.out.println(mid);
            if (matrix[mid][0] == target) {
                return true;
            }else if (matrix[mid][0] > target) {
                j = mid-1;
            }else {
                if (matrix[mid][col-1] == target) {
                    return true;
                }else if (matrix[mid][col-1] > target) {
                    i = mid;
                    break;
                }else{
                    i = i+1;
                }
            }
        }
        if(i < 0 || i >= row) {
            return false;
        }
        int l = 0, r = col-1;
        while (l <= r) {
            int mid = l + ((r-l)>>1);
            if (matrix[i][mid] == target) {
                return true;
            }else if (matrix[i][mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }
}
