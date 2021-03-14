package part_1.medium.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic417 {

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int row, col;
    private static int[][] matrix = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };; // 创建一个全局的数组

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(matrix));
    }


    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        /*
         * 分析题意：首先搞清楚一点水往低处流，然后每个板块只要能通过相连的任意板块
         * 流通到太平洋同时又能流通到大西洋就是满足题意的结果。
         */
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return result;
        }
        row = matrix.length;
        col = matrix[0].length;
        boolean[][] canReachPacific = new boolean[row][col];
        boolean[][] canReachAtlantic = new boolean[row][col];
//        this.matrix = matrix;

        // 从左边缘开始dfs所有能流通到太平洋的大陆板块，从右边缘大陆板块开始dfs所有能流通到大西洋的大陆板块
        for(int i = 0; i < row; ++i) {
            dfs(i, 0, canReachPacific);
            dfs(i, col - 1, canReachAtlantic);
        }

        // 从上边缘开始dfs所有能流通到太平洋的大陆板块，从下边缘大陆板块开始dfs所有能流通到大西洋的大陆板块
        for(int j = 0; j < col; ++j) {
            dfs(0, j, canReachPacific);
            dfs(row - 1, j, canReachAtlantic);
        }

        // 遍历所有的板块把既能流通到太平洋又能流通到大西洋的板块添加到结果集
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static void dfs(int r, int c, boolean[][] canReach) {
        if(canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for(int[] d : directions) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            // 如果dfs的新节点位置越界了或者高度没有前序节点高度高
            if(nextR < 0 || nextR >= row || nextC < 0 || nextC >=col || matrix[r][c] > matrix[nextR][nextC]) {
                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }

}
