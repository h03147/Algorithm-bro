package part_1.hard.ufs;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 803 打砖块 支离破碎的并查集逆向操作
 */
public class HitBricks803 {

    private static int rows;
    private static int cols;

    // 方向数组，用于访问网格中某个坐标点上下左右位置的操作(上右下左)
    public static final int[][] DIRECTIONS  = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 803题用到的全局变量 end

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = {{1, 0}};
        List<Integer> array2list = new ArrayList<Integer>();
        for(int res : hitBricks(grid, hits)) {
            array2list.add(res);
        }
        System.out.println(array2list);
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {

        /*
         * 消除一个砖块的效果是：一个连通分量被分成了两个连通分量；
         * 并查集的作用是：把两个连通分量合并成一个连通分量。
         * 故想用并查集 需要逆向操作这个问题。
         */
        rows = grid.length;
        cols = grid[0].length;

        // step 3 把grid网格中的砖头全部击碎，这里我们copy一份后敲碎副本
        int[][] copy = new int[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        // 把copy敲碎（所有需要敲碎的1变成0）
        for(int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        // step 4 把砖块之间的关系输入并查集，size表示二维空间网格大小，也表示稳定的屋顶
        int size = rows * cols;
        UnionFind803 unionFind803 = new UnionFind803(size + 1); // 因为要表示屋顶所以要+1

        // 将横坐标为0的行砖块与屋顶相连
        for(int j =0; j < cols; ++j) {
            if(copy[0][j] == 1) {
                unionFind803.union(j, size);
            }
        }

        // 其余网格位置砖块只考虑向上向左 是否有砖块相连（题目规律），故在并查集中进行合并
        for(int i = 1; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                if(copy[i][j] == 1) {
                    // 先判断上面是否有砖块相连
                    if(copy[i - 1][j] == 1) {
                        unionFind803.union(getIndex(i - 1, j), getIndex(i , j));
                    }
                    // 再判断左边是否有砖块相连
                    if(j > 0 && copy[i][j - 1] == 1) {
                        unionFind803.union(getIndex(i, j - 1), getIndex(i , j));
                    }
                }
            }
        }

        // step 5 按照hits的逆序， 在copy中补回砖块， 把每一次因为补回砖块而能够与屋顶相连的
        // 砖块的增量记录到res数组中
        int hitsLength = hits.length;
        int[] res = new int[hitsLength];
        for(int i = hitsLength - 1; i >= 0; --i) {
            int x = hits[i][0];
            int y = hits[i][1];

            // 如果原grid中这一块位置本来就没有砖块，那就敲了个寂寞，也不会有砖块会因此掉落，故跳过
            if(grid[x][y] == 0) {
                continue;
            }

            // 反向补回与屋顶相连的砖块数量
            int origin = unionFind803.getSize(size);

            // 如果补的砖块是第一行则与屋顶直接相连
            if(x == 0) {
                unionFind803.union(y, size);
            }

            // 上右下左看下有没有相邻砖块可以合并
            for(int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                //  没越界且有砖块可以连接
                if(inArea(newX, newY) && copy[newX][newY] == 1) {
                    unionFind803.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            // 补回之后与屋顶相连的砖块数
            int current = unionFind803.getSize(size);
            // 最后用敲击前后与屋顶相连砖块个数减去1， 与0比较大小（可能存在添加当前砖块不会使其与屋顶
            // 相连的砖块数更多，减去1会得出-1这个值，而最小应该是0，没有任何增加）
            res[i] = Math.max(0, current - origin - 1);

            // 然后补回这个砖块是其恢复最先开始的原样
            copy[x][y] = 1;
        }
        return res;
    }

    // 判断输入的二维坐标是否越界
    private static boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    // 由于并查集操作时一维坐标的操作，本题图是二维坐标，所以需要做降为操作
    private static int getIndex(int x, int y) {
        return x * cols + y;
    }

    // step 1 由于本题设计连通性问题，考虑用并查集实现
    private static class UnionFind803 {
        // 当前节点的父节点
        private int[] parent;
        // 以当前节点为根节点的子树的个数
        private int[] size;

        public UnionFind803(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 路径压缩
        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            // 合并时维护数组size
            size[rootY] += size[rootX];
        }

        // step 2 返回x在并查集根节点的子树包含的节点的总数
        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
