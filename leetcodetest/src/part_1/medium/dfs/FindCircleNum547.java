package part_1.medium.dfs;

public class FindCircleNum547 {

    private static int n;


    public static void main(String[] args) {
        int[][] isConnected = { {1, 1, 0},
                                {1, 1, 0},
                                {0, 0, 1} };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        /*
         * 分析题意：之前做的dfs题目是直接给你一个图，让你在图中判断是否相连，本题中图里面的值
         * 仅仅表示值对应位置坐标的横坐标值和纵坐标值之间有边，并且没有方向。比如坐标(i, j)位置
         * 值为1，表示i和j是连通的，而(j, i)位置值为1，也表示一个意思，i和j是连通的。故是无向连
         * 通图找连通分量的个数问题。故这题给的图一定是对称的图，如果(i, j)位置值为1，那么(j, i)
         * 位置值必然为1。
         */

        // 由于是无向图，所以矩阵是斜对角先对称的，这里城市a和城市b相连和城市b与城市a相连是一个意思，故只用
        // 获取行总数就行了
        n = isConnected.length;
        // 访问过的城市无需再次访问，上标记
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; ++i) {
            // 如果城市i没有访问过就去dfs找到所有和i相连的城市
            if(!visited[i]) {
                dfs(isConnected, i, visited);
                // 一趟dfs结束后，所有与i相连的城市就全部找到了，找到了一个连通分量，做加1运算
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for(int j = 0; j < n; ++j) {
            // 如果城市i和城市j相连，并且城市j还未访问过，就以j为新的节点继续递归找到与j相连的其他城市
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, j, visited);
            }
        }
    }
}
