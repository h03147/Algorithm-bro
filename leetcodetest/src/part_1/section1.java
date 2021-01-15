package part_1;

import java.util.*;

/**
 * author: Arthur Ye
 * description: all questions is from leetcode
 * you can use the question number to search more details for any question in leetcode
 *
 */

public class section1 {

    public static void main(String[] args) {
//        int[] array1 = {2,8,4,1,8,1};
//        System.out.println(stones(array1));
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {4, -2};
//        int k = 3;
//        System.out.print("[");
//        for(int item : maxSlidingWindow(nums, k))
//        {
//            System.out.print(item + "," + " ");
//        }
//        System.out.print("]");

//        int[] nums = {1,2,3,4,5,6,7};
//        int k =3;
//        System.out.println(rotate(nums, k));;

        // git push test
        // 1202
//        String s = "dcab";
//        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
//        List<Integer> pair1 = new ArrayList<Integer>();
//        pair1.add(0);
//        pair1.add(3);
//        List<Integer> pair2 = new ArrayList<Integer>();
//        pair2.add(1);
//        pair2.add(2);
//        pairs.add(pair1);
//        pairs.add(pair2);
//        System.out.println(smallestStringWithSwaps(s, pairs));

//        // 684
//        /**
//         * [[1,2], [1,3], [2,3]] 无向图边连接关系
//         *       1
//         *     *   *
//         *    2  *  3
//         */
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
//        List<Integer> result_list = new ArrayList<Integer>();
//        for(int item : findRedundantConnection(edges)) {
//            result_list.add(item);
//        }
//        System.out.println(result_list);

//        // 1018
//        int[] A = {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1};
//        System.out.println(prefixesDivBy5(A));

//        // 990
//        String[] equations = {"a==b", "b==c", "a==c"};
//        System.out.println(equationsPossible(equations));

        // 947
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));


    }

    // 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    private static int finds2c(String s) {
        char[] s2c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char item : s2c)
        {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for(int i =0; i < s2c.length; ++i)
        {
            if(map.get(s2c[i]) == 1)
            {
                return i;
            }
        }
        return -1;
    }

    // 粉碎石头
    private static int stones(int[] stones) {
        // {2,7,4,1,8,1}
        ArrayList<Integer> arr2list = new ArrayList<Integer>();
        int size = stones.length;
        for(int i = 0; i < size; ++i)
        {
            arr2list.add(stones[i]);
        }

        while (size > 1) {
            Integer max1 = Collections.max(arr2list);
            arr2list.remove(max1);
            Integer max2 = Collections.max(arr2list);
            arr2list.remove(max2);
            if (max1 > max2) {
                int newstone = max1 - max2;
                arr2list.add(newstone);
                size -= 1;
            } else {
                size -= 2;
            }

        }
        if(arr2list.size() == 1)
        {
            return arr2list.get(0);
        }else {
            return 0;
        }
    }

    //leetcode239题滑动窗口 双端队列解决超时问题，时间复杂度为O(n)
    private static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值(下标)按从大到小排序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果当前队列中的队首值也就是最大值小于等于正在遍历的数，则队列全部弹出
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前最新的最大值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效，如果在窗体外就弹出队首对应的
            // 下标( i-k为窗体的左边界L，i为右边界)
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值(即已经形成了一个完整窗口后)
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    // 189. 旋转数组
    public static List<Integer> rotate(int[] nums, int k) {
        // // 方法一
        // int n = nums.length;
        // int[] newarr = new int[n];
        // for(int i = 0; i < n; ++i) {
        //     newarr[(i + k) % n] = nums[i];
        // }
        // System.arraycopy(newarr, 0, nums, 0, n);

        // 方法二 三次原地自转
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        List<Integer> nums2list = new ArrayList<Integer>();
        for(int item : nums) {
            nums2list.add(item);
        }
        return nums2list;
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp = nums[start];
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 1202. 交换字符串中的元素
    private static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0) {
            return s;
        }

        // 1.任意交换节点对输入并查集构成连通分量并做路径压缩
        int length = s.length();
        UnionFind unionFind = new UnionFind(length);
        for(List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        // 2.构建映射关系，每个索引key位置可能存在的字符集合value
        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(length);
        for(int i = 0; i < length; ++i) {
            int root = unionFind.find(i);
            // 一 对 多 建立映射关系
            hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        // 3.把重组后的最小字典集字符串返回
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; ++i) {
            int root = unionFind.find(i);
            // 对头元素移除
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }

    // 构建并查集类
    private static class UnionFind {

        // 声明父节点数组
        private int[] parent;

        // 以i为根节点子树高度
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; ++i) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }

            if(rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    // 684. 冗余连接 考察并查集 加 树和无向图冗余后边的特点
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

    // 1018 可被 5 整除的二进制前缀 位运算 + 数学分析
    public static List<Boolean> prefixesDivBy5(int[] A) {
        /**
         * 思路，能被5整除的十进制数，任意一个数减去个位数的值后都是一个整数，整数都能被5整除
         * 所以本题十位数以上一定能被5整除不用考虑，只用考虑到每次得到的十进制数的个位能否被5
         * 整除即可
         **/
        int size = A.length;
        int sum = 0;
        List<Boolean> result_list = new ArrayList<Boolean>();
        // // 1.可读性高 方便理解版
        // for(int i = 0; i < size; ++i) {
        //     sum <<= 1; // 每次上一个数做位运算左移一位变成下一个数的十位数
        //     sum += A[i]; // 下一个数等于上一个十进制数加上当前最后一位二进制
        //                 // (最后一位二进制数无论是0或者1都和换算成十进制数值都一样所以可以直接加)
        //     sum %= 10; // 取个位数
        //     result_list.add(sum % 5 == 0);
        // }

        // 2.减少代码冗余版 根据数论中同余运算规则 sum %= 10 等价于 sum %= 5
        for(int item : A) {
            result_list.add( ( sum = ((sum << 1) + item) % 5 ) == 0);
        }

        return result_list;

    }

    // 990. 等式方程的可满足性
    public static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for(String str : equations) {
            if(str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        for(String str : equations) {
            if(str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                // 在前面等式关系中找到了不等式关系的反例，则返回false
                if(find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int find1(int[] parent, int index) {
        while(parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void union1(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    // 947 移除最多同行或同列的石头
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
