package part_1.medium.ufs;

import java.util.*;

/**
 * description: 1631. 最小体力消耗路径
 */
public class MinimumEffortPath1631 {
    public static void main(String[] args) {
        int[][] heights = {{1 ,2 , 2}, {3 ,8 , 2}, {5 ,3 , 5}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                int id = i * n + j;
                // 向下走
                if(i > 0) {
                    edges.add(new int[] {id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                // 向右走
                if(j > 0) {
                    edges.add(new int[] {id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        // 比较找出最小的体力消耗（权值差）
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        UnionFind1631 unionfind1631 = new UnionFind1631(m * n);
        int answer = 0;
        for(int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            unionfind1631.union(x, y);
            // 所有的网格的可能
            if(unionfind1631.connected(0, m * n - 1)) {
                answer = v;
                break;
            }
        }
        return answer;
    }
    // 并查集模板
    public static class UnionFind1631 {
        int[] parent;
        int[] size;
        int n;

        // 当前连通分量数目
        int setCount;

        public UnionFind1631(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];

            // 数组填充 把size数组里面的值全部填充为1
            Arrays.fill(size, 1);
            for(int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean union(int x, int y) {
            x = findset(x);
            y = findset(y);
            if(x == y) {
                return false;
            }
            if(size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findset(x);
            y = findset(y);
            return x == y;
        }

    }
}
