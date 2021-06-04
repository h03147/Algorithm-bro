package part_1.medium.graph;

public class FindRedundantConnection684 {

    public int[] findRedundantConnection(int[][] edges) {
        /*
         * 分析题意：本题结果要求的就相当于把无向图中的环去掉，变成树，数的结构刚好是如果有 N 个顶点，那么恰好有 N - 1 条边
         * 而本题恰好多出了一条边， 导致了 N 个点有 N 条边，且第 N 条边和前面的边不重复，那就必然有环。
         * 经典解法用并查集 + dfs 求解。
         */
        // 图中节点个数就是edges的个数
        int nodesCount = edges.length;
        // 本题节点值范围是1——N，N个数的范围，但是数组下标取值从0开始，N个数就是到N - 1的下标位置，为了保证一致性，故加1
        int[] parent = new int[nodesCount + 1];
        // 在parent数组中初始化每一个节点
        for(int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        // 去遍历edges二维数组中的每一对节点边关系判断是否在同一个连通分量上，不是就进行合并，这样
        // 再次出现就可以检查到环（冗余）
        for(int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if(find(parent, node1) != find(parent, node2)) {
                // 如果两个节点不在同一个连通分量上，证明还未连通，对他们进行连通即可。
                union(parent, node1, node2);
            } else {
                // 否则说明之前已经连通过了，已经在一个连通分量下了，说明这条边就是我们要找的冗余的那一个边，直接返回
                return edge;
            }
        }
        // 如果不存在冗余的连接，返回空或者非题中节点的编号即可
        return new int[] {0, 0};
    }

    // 查找当前节点的根节点
    private int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    // 合并多个连通分量为一个，我们默认让index2对应的连通分量的根节点的父亲连接index1的根节点即可（路径压缩）
    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = parent[find(parent, index2)];
    }

}
