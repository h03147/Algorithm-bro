package part_1.medium.ufs;


import java.util.HashMap;
import java.util.Map;

/**
 * description: 947 移除最多同行或同列的石头
 */
public class RemoveStones947 {

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        /**
         * 理解本题核心思想
         * 按题意把所有横纵坐标相同的点在二维平面上用横线或者竖线连接起来，形成一个极大连通子图，而每一个
         * 极大连通子图，最后都能删除成为仅有一个节点(这里可叫做根节点)，那么有多少个极大连通子图，最后
         * 每个连通子图删除到只会剩下一个节点也就是根节点，正好根节点个数和极大连通子图是1:1的关系，故
         * 总结点个数减去极大连通子图(连通分量)个数则就是我们最大能删除的节点的个数。
         **/
        UnionFind947 unionFind = new UnionFind947();

        for(int[] stone : stones) {
            // 因为并查集是一个一维数组解决方案，而本题是二维数组，x和y相连存在x和y坐标可能相同需要区分
            // 我们有两种方法，方法1.直接让x值或y值取反，方法2.根据题意x，y的取值范围为（0，10000），
            // 故我们让x值或y值加上或者减去10000即可区分x和y
            // 这里为了代码可读性我选择让x（横坐标）值加10000
            // unionFind.union(~stone[0], stone[1])
            // unionFind.union(stone[0] - 10000, stone[1])
            unionFind.union(stone[0] + 10000, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private static class UnionFind947 {
        // 用哈希而不用常规的数组是因为hashMap可以动态扩容，本题我们无法知道连通分量个数，需要不断取判断，
        // 故HashMap更合适
        private Map<Integer, Integer> parent;
        // 记录连通分量个数
        private int count;

        // 构造函数的初始化
        public UnionFind947() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            // 如果当前连通图中不存在节点x，则把他加入进去，增加一个连通分量
            if(!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            // 如果x不等于他父亲的值 就进行路劲压缩，让x父亲节点变成根节点
            if(x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            // 返回x的根节点
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                // 如果x，y根节点相同就什么都不做
                return;
            }
            // 否则把x根节点连到y根节点上，此时两个连通分量合并成一个了，count要减一
            parent.put(rootX, rootY);
            count--;
        }
    }
}
