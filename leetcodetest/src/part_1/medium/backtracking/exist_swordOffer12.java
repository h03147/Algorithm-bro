package part_1.medium.backtracking;

public class exist_swordOffer12 {

    private final static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        if(rows == 0 || cols == 0) return false;
        char[] word2char = word.toCharArray();
        boolean[][] marked = new boolean[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                if(backtracking(board, word2char, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, char[] word2char,
                                 boolean[][] marked, int pathLen, int r, int c) {
        if(pathLen == word2char.length) return true;
        if(r < 0 || r >= rows || c < 0 || c >= cols
                || board[r][c] != word2char[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        for(int[] n : direction) {
            if(backtracking(board, word2char, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

}
