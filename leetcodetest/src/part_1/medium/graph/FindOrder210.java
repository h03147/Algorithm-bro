package part_1.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class FindOrder210 {

    // 创建有向依赖关系的图（有向图）
    private List<List<Integer>> edges;
    // 用一个数组记录节点的访问状态
    int[] visited;
    // 判断拓扑结构是否有效，默认有效（换句话说：判断图中是否有环）
    boolean valid = true;
    // 返回结果，因为题目要求返回int型数组，而我们用到栈结构的话还是要转换存储到数组中，故直接用数组模拟栈结构
    // 数组下标index 在 numCourses - 1 位置为栈底，在 0 位置为栈顶
    int[] result;
    // 栈的索引下标
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 外层内层list分别初始化
        edges = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        // 把prerequisites的矩阵结构转换成list结构，构建依赖有向图（类似于邻接表）
        // 外层list下标为前序课程编号，内层存储的是当前课程编号 构成 info[1] --> info[0] 的有向关系
        for(int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 是否访问节点标记的空间大小以及返回结果数组的大小都是numCourses（也就是课程数量n）
        visited = new int[numCourses];
        result = new int[numCourses];
        // 初始化栈底下标在result数组末尾，反向存储回来。这样返回结果的输出是从下标0开始向后读正好模拟栈的依次弹出操作
        index = numCourses - 1;
        // 每次挑选一个未搜索的节点进行dfs
        for(int i = 0; i < numCourses && valid; ++i) {
            // 为0，满足条件，进行dfs
            if(visited[i] == 0) {
                dfs(i);
            }
            // 有环则不能串联所有课程，返回空数组即可
            if(!valid) {
                return new int[] {};
            }
        }
        // 无环，且有拓扑排序则返回结果
        return result;
    }

    private void dfs(int u) {
        // 将当前节点标记为搜索中
        visited[u] = 1;
        // 遍历dfs搜索其邻接节点，寻找合适的拓扑结构，发现环马上停止搜索
        for(int v : edges.get(u)) {
            if(visited[v] == 0) {
                // 如果邻接节点未搜索就dfs搜索他
                dfs(v);
                if(!valid) {
                    return;
                }
            } else if(visited[v] == 1) {
                // 发现在其状态是搜索中，则说明找到环了，是无效的路径，马上停止搜索
                valid = false;
                return;
            } // else 就是状态2的节点v说明已经在栈里面了，而u还未入栈，则一定满足在栈中v在u的下面，逆序弹出栈满足拓扑排序
        }
        // 搜索完毕把u状态改为已完成搜索
        visited[u] = 2;
        // 当前节点u入栈底，栈顶下标前移
        result[index--] = u;
    }

}
