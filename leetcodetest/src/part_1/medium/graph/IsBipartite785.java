package part_1.medium.graph;

import java.util.Arrays;

public class IsBipartite785 {

    public boolean isBipartite(int[][] graph) {
        // 创建一个染色表，长度为无向图节点长度，赋值只有两种相异的颜色码，我们用0和1表示两种相异的颜色码
        int[] colors = new int[graph.length];
        // 把所有节点都初始化赋值为-1，代表还没有遍历染色到该节点，为预备染色节点
        Arrays.fill(colors, -1);
        // 遍历每个节点去验证他的邻接表对应的所有邻接节点是不是都和他的颜色码刚好相异
        for(int i = 0; i < graph.length; ++i) {
            // 进一步判断图是否连通，可能存在多个连通图即不是所有节点都组成一个连通图的情况
            if(colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    // 重载判断当前节点和其邻接节点是否正好二分染色（是否恰好组成二分图）
    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        // 若在遍历前面节点的时候已经通过邻接表的形式dfs进行了染色(无向图前面染了后面避免重复操作)，就只用进一步
        // 验证他之前已经染了的颜色和我们当前正要给他染的颜色是否相同，不相同则说明是非二分图返回false否则返回true
        if(colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        // 初始化第一个节点默认染成颜色0，如果是通过邻接表dfs进来的节点就染成和当前节点相异的颜色码
        // (即 1 - curNode 的结果非0即1)
        colors[curNode] = curColor;
        // 遍历邻接表
        for(int nextNode : graph[curNode]) {
            // dfs判断与当前节点(curNode)直接相邻的下一个节点(nextNode)是否正好和当前节点的颜色相异
            // 当前节点颜色为curColor，那和他相异就是 1 - curColor （1 - 0 = 1， 1 - 1 = 0)
            // 只要颜色不相异了就马上return false 向上收敛回去
            if(!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        // 当前节点邻接的所有节点都满足颜色相异return true收敛回去
        return true;
    }

}
