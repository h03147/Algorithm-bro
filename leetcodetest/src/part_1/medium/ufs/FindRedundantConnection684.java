package part_1.medium.ufs;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 684. 冗余连接 考察并查集 加 树和无向图冗余后边的特点
 */
public class FindRedundantConnection684 {

    public static void main(String[] args) {
        //        /**
//         * [[1,2], [1,3], [2,3]] 无向图边连接关系
//         *       1
//         *     *   *
//         *    2  *  3
//         */
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        List<Integer> result_list = new ArrayList<Integer>();
        for(int item : findRedundantConnection(edges)) {
            result_list.add(item);
        }
        System.out.println(result_list);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        /**
         * 并查集题目 加 分析树的特点，N个顶点，应该有N-1条边才是无环的树
         **/
        // step 2. 回到本题
        // 获取书中所有边个数
        int nodesCount = edges.length;
        // 现在树中有冗余环，本题中附加了一条边
        int[] parent = new int[nodesCount + 1];
        for(int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        for(int i = 0; i < nodesCount; ++i) {
            // 把每个边对应的两个点拿出来
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 如果两个节点不在同一个连通分量上，即遍历时不连通，则不是坏边(冗余)，
            // 进行合并操作, 否则就是坏边，返回即可
            if(find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }
    // step 1. 无脑输出并查集两个经典方法find 和 union
    public static int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
}
