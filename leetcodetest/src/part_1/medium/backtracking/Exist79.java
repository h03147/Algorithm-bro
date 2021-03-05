package part_1.medium.backtracking;

public class Exist79 {

    private final static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int row, col;

    public static void main(String[] args) {
        char[][] board =
                {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] hasVisited = new boolean[row][col];

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(backTracking(0, i, j, hasVisited, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backTracking(int curLen, int r, int c, boolean[][] hasVisited, char[][] board, String word) {
        if(curLen == word.length()) {
            return true;
        }

        if(r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(curLen) || hasVisited[r][c]) {
            return false;
        }

        hasVisited[r][c] = true;

        for(int[] d : directions) {
            if(backTracking(curLen + 1, r + d[0], c + d[1], hasVisited, board, word)) {
                return true;
            }
        }

        // 当前这一次dfs未完整匹配到word，回溯到上一个节点位置，并且把当前访问过不合适的节点还原成为访问的状态
        hasVisited[r][c] = false;

        return false;
    }

}
