package part_1.medium.dp;

public class maxValue_swordOffer47 {

    public int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        // 初始化第一行
        for(int i = 1; i < col; ++i) {
            grid[0][i] += grid[0][i - 1];
        }
        // 初始化第一列
        for(int j = 1; j < row; ++j) {
            grid[j][0] += grid[j - 1][0];
        }
        for(int i = 1; i < row; ++i) {
            for(int j = 1; j < col; ++j) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }

}
