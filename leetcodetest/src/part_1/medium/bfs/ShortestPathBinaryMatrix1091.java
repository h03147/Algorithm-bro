package part_1.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix1091 {
    // 定义方向数组，共八个方向
    static int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static  int row, col;
    static  int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        /*
         * 分析题意：广度优先搜索一层一层地进行遍历，每层遍历都是以上一层遍历的结果作为起点，
         * 遍历一个距离能访问到的所有节点。需要注意的是，遍历过的节点不能再次被遍历。
         * 每一层遍历的节点都与根节点距离相同。设 di 表示第 i 个节点与根节点的距离，推导出一
         * 个结论：对于先遍历的节点 i 与后遍历的节点 j，有 di <= dj。利用这个结论，可以求解
         * 最短路径等 最优解 问题：第一次遍历到目的节点，其所经过的路径为最短路径。应该注意
         * 的是，使用 BFS 只能求解无权图的最短路径，无权图是指从一个节点到另一个节点的代价都记为 1。
         * 在程序实现 BFS 时需要考虑以下问题：
         * 队列：用来存储每一轮遍历得到的节点；
         * 标记：对于遍历过的节点，应该将它标记，防止重复遍历。
         */
        row = grid.length;
        col = grid[0].length;
        // 初始情况下，如果左上角或右下角为1，表示阻塞则不可到达/
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        // 初始情况下从空到左上角开始走要消耗一个步长，原地记录访问到当前节点需要的步长。
        grid[0][0] = 1;
        // BFS算法，为每一个可能到达的节点，开辟一个队列空间。
        Queue<int[]> pos = new LinkedList<>();
        // 初始情况下节点位置为(0, 0)。
        pos.offer(new int[]{0, 0});
        // 如果还存在可能访问的节点，并且右下角还未访问到。
        while(!pos.isEmpty() && grid[row - 1][col - 1] == 0) {
            // 取当前节点开始广度优先探寻下一个可能到达的节点。
            int[] xy = pos.poll(); // queue.poll()方法表示取出当前队头元素并删除。
            int preLength = grid[xy[0]][xy[1]]; // 记录访问到当前节点需要的步长。
            // BFS八个方向
            for(int i = 0; i < 8; ++i) {
                int newX = xy[0] + directions[i][0]; // 横轴所有可能的方向
                int newY = xy[1] + directions[i][1]; // 纵轴所有可能的方向。
                if(inGrid(newX, newY) && grid[newX][newY] == 0) {
                    pos.offer(new int[]{newX, newY}); // 找到的下一个可以访问的新节点。
                    grid[newX][newY] = preLength + 1; // 当前位置上存储访问该节点需要的步长。
                }
            }
        }
        // BFS探寻结束，可能能探寻到右下角的节点，也可能到达不了右下角（中途所有到达下一个几点的路径都被阻塞了）。
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    // 判断当前位置是否越界
    private static boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
