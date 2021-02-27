package part_1.medium.dfs;

public class NumIslands200 {

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int m, n;

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int areaCount = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    areaCount++;
                }
            }
        }
        return areaCount;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >=m || j < 0 || j >=n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        for(int[] d : directions) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }

}
