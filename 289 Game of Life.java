public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board,i,j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    private void helper(int[][] board, int i, int j){
        int live = 0;
        int row = board.length - 1, col = board[0].length - 1;
        for (int m = Math.max(i-1, 0); m <= Math.min(i + 1, row); m++) {
            for (int n = Math.max(0, j-1); n <= Math.min(col, j + 1); n++) {
                if (board[m][n] == 1 || board[m][n] == 3) {
                    live++;
                }
            }
        }
        live -= board[i][j];
        if (board[i][j] == 0 && live == 3) {
            board[i][j] = 2;
        }else if (board[i][j] == 1 && (live == 2 || live == 3)) {
            board[i][j] = 3;
        }
    }
}
