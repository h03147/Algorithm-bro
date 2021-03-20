package part_1.medium.dp;

public class MinPathSum64 {


    public static void main(String[] args) {
        System.out.println(new MinPathSum64().minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

     /**
     * V(xy): 坐标 x,y 点的值
     * f(x,y): 0,0 到坐标 x,y 的最小路径和
     * 因为要求 从左上到右下x,y的最小路径和
     * 求x,y的最小路径和就是求 x,y的上一个坐标或x,y左边一个坐标 + x,y坐标的值
     * a=f(x-1,y)
     * b=f(x,y-1)
     * f(x,y) = min[a,b] + V(xy)
     **/

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 初始化第一行(行不动为0，列动)
        for(int i = 1; i < col; ++i) {
            grid[0][i] += grid[0][i - 1];
        }

        // 初始化第一列 (行动，列不动为0)
        for(int i = 1; i < row; ++i) {
            grid[i][0] += grid[i - 1][0];
        }

        // 寻找最小路径和
        for(int i = 1; i < row; ++i) {
            for(int j =1; j < col; ++j) {
                int min = Math.min(grid[i - 1][j], grid[i][j - 1]);
                grid[i][j] += min;
            }
        }
        return grid[row - 1][col - 1];
    }

}
