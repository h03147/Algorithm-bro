package part_1.hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens51 {

    private List<List<String>> answers;
    private char[][] nQueues;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    int n;

    public static void main(String[] args) {
        int n = 8;
        SolveNQueens51 solveNQueens51 = new SolveNQueens51();
        System.out.println(solveNQueens51.solveNQueens(n));
    }


    public List<List<String>> solveNQueens(int n) {
        answers = new ArrayList<>();
        nQueues = new char[n][n];
        // 用填充数组初始化每一行后给填充为'.'， 当占位符
        for(int i = 0; i < n; ++i) {
            Arrays.fill(nQueues[i], '.');
        }
        colUsed = new boolean[n];
        // 一整个 n * n 的网格中，网格内部45度角线总共能画 2 * n - 1， 135度同理
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        this.n = n;
        // 初始化的时候从第一行开始行序遍历
        backTracking(0);
        return answers;
    }

    private void backTracking(int row) {
        // 如果能递归到最后遗憾，说明正好放下了第n个皇后，有结果了
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(char[] chars : nQueues) {
                list.add(new String(chars));
            }
            answers.add(list);
            return;
        }

        for(int col = 0; col < n; ++col) {
            // 45度角上面所有的点 (r, c) 的位置所在的数组下标值都相等， 为 r + c
            int diagonals45Index = row + col;
            // 135度角上的所有点 (r, c) 的位置所在的数组下标值都相等，为 n - 1 - (r , c)
            int diagonals135Index = n - 1 - (row - col);
            if(colUsed[col] || diagonals45Used[diagonals45Index] || diagonals135Used[diagonals135Index]) {
                continue; // 当前列不合适，我们先继续向右走一个，判断下一列
            }
            nQueues[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonals45Index] = diagonals135Used[diagonals135Index] = true;
            backTracking(row + 1); // 继续递归到下一行去找下一个合适的位置
            // 如果一趟dfs结束后， 没有把n个皇后都安排完毕或者找到了一个组合我们也不要结束判断，我们就开始回
            // 溯到上一步找其他合适的能装下n个皇后的组合位置
            colUsed[col] = diagonals45Used[diagonals45Index] = diagonals135Used[diagonals135Index] = false;
            nQueues[row][col] = '.'; // 当前位置放皇后不合适，重新置空
        }
    }


}
