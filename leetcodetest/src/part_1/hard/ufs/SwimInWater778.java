package part_1.hard.ufs;


/**
 * description: 778. 水位上升的泳池中游泳
 */
public class SwimInWater778 {
    private static int n;

    public static final int[][] Directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{0, 2}, {1, 3}};
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        n = grid.length;

        int length = n * n;
        // 下表是高度， 值为grid对应的坐标
        int[] index = new int[length];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                index[grid[i][j]] = getIndex778(i ,j);
            }
        }

        UnionFind778 unionFind778 = new UnionFind778(length);
        for(int i = 0; i < length; ++i) {
            int x = index[i] / n;
            int y = index[i] % n;

            for(int[] direction : Directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(inArea778(newX, newY) && grid[newX][newY] <= i) {
                    unionFind778.union(index[i], getIndex778(newX, newY));
                }

                if(unionFind778.isConnected(0, length - 1)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private static int getIndex778(int x, int y) {
        return x * n + y;
    }

    private static boolean inArea778(int x, int y) {
        return x >= 0 && x < n && y >=0 && y < n;
    }

    private static class UnionFind778 {
        private int[] parent;

        public UnionFind778(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            if(isConnected(x, y)) {
                return;
            }
            parent[find(x)] = find(y);
        }
    }
}
