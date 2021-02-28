package part_1.medium.dfs;

public class Solve130 {

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int row, col;

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        for(char[] c1 : board) {
            System.out.print(c1);
            System.out.println();
        }
        System.out.println("   ---———转换后———----   ");
        solve(board);
        for(char[] c2 : board) {
            System.out.print(c2);
            System.out.println();
        }
    }


    public static void solve(char[][] board) {
        /*
         * 分析题意：按题目的意思，需要我们把所有不在四边边缘上并且不与四边边缘上的'O'相连
         * 位置上的'O'修改为'X'。那么难就难再我们怎么知道里面的O不与四周边缘上的O相连，难
         * 道每次都要去判断嘛，显然这样会很费时。所以这里我们反向操作一波，先用dfs，把所有
         * 四边边缘上的'O'以及与其相连的里面的'O'全部改成'T'。剩下的就是里面被'X'包围的'O'
         * 了，然后我们再遍历一边图把所有的'T'恢复成'O'（这些都是与边缘相连的'O'），把所有
         * 的'O'(这些都是除开与边缘相连'O'剩下'X'被包围的'O'了)改成'X'就能满足题意了。
         */
        row = board.length;
        col = board[0].length;

        // 首先按行进行dfs，把图的左边缘以及右边缘上所有元素的'O'以及与其相连的'O'都改成'T'
        for(int i = 0; i < row; ++i) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }

        // 其次按列进行dfs，把图的上边缘以及下边缘上所有元素的'O'以及与其相连的'O'都改成'T'
        for(int j = 0; j < col; ++j) {
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }

        // 最后遍历一边图，把所有的'T'恢复成'O'，把所有的'O'改成'X'
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for(int[] d : directions) {
            dfs(board, r + d[0], c + d[1]);
        }
    }

}
