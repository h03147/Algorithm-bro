package part_1.medium.dfs;

public class MaxAreaOfIsland695 {

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 上右下左四个方向
    private static int row, col; // 总行数和总列数的定义


    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c) {
        // 判断当前传入坐标位置是否越界或是否为水域
        if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0; // 已访问过的岛屿也修改为0，避免重复访问
        int area = 1; // 每个岛屿的面积为1
        for(int[] d : directions) {
            // 在四个方向上开始深度优先探寻,探寻完毕后再返回上一层累加
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }
}
