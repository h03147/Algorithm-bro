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

//        // 947
//        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
//        System.out.println(removeStones(stones));

//        // 803
//        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
//        int[][] hits = {{1, 0}};
//        List<Integer> array2list = new ArrayList<Integer>();
//        for(int res : hitBricks(grid, hits)) {
//            array2list.add(res);
//        }
//        System.out.println(array2list);

//        // 628
//        int[] nums = {1, 2, 3, 4};
//        System.out.println(maximumProduct(nums));

        // 1128
        int[][] dominoes ={{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(dominoes));


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

    // 803 打砖块 支离破碎的并查集逆向操作

    // 803题用到的全局变量 start
    private static int rows;
    private static int cols;

    // 方向数组，用于访问网格中某个坐标点上下左右位置的操作(上右下左)
    public static final int[][] DIRECTIONS  = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 803题用到的全局变量 end

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

    //628 三个数的最大乘积
    public static int maximumProduct(int[] nums) {
        /*
        分析情况：
        方法1. 基于排序的方法
        1. 数组中的数全是正数，取最大的三个数相乘即可，数组中全是负数取还是取最大的三个数相乘即可
        2. 数组中整数负数全都有，则最大值可能是三个最大正数相乘，或者是两个最小负数相乘再乘一个最
           大正数
        综上：在排序后，最大值取三个最大整数或者是两个最小负数和一个最大整数相乘这两种情况就包揽了
        全部的解
        */
        // Arrays.sort(nums);
        // int n = nums.length;
        // return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);

        /*
        方法2. 根据方法1.的总结可以知道最终的目的就是找到五个数，不需要排序的方法，也无论正负数直接一
        趟遍历根据排队传递性规则找出最大的三个数，外加两个最小的数即可
        */
        // 首先找出最小的两个数,min1最小，min2第二小
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 再就是最大的第二大和第三大的三个数(max1, max2, max3)
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int item : nums) {
            if(item < min1) {
                min2 = min1;
                min1 = item;
            } else if (item < min2) {
                min2 = item;
            }

            if(item > max1) {
                max3 = max2;
                max2 = max1;
                max1 = item;
            } else if(item > max2) {
                max3 = max2;
                max2 = item;
            } else if(item > max3) {
                max3 = item;
            }
        }

        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }

    // 1128. 等价多米诺骨牌对的数量 二元数组，正反相等
    public static int numEquivDominoPairs(int[][] dominoes) {
        // 既然是二元组，不妨把两个数拼成一个数做降维操作
        // 本题的核心思想需要比较和交换，让二元组中第一个数始终小于第二个数，
        // 然后让第一个数当十位，第二个数当个位，这样组成的一个两位数当作计数数组的下标即可
        // [a, b] => if (a < b) {a * 10 + b} else {b * 10 + a}
        int[] copy = new int[100];
        int answer = 0;
        for(int[] arr : dominoes) {
            answer += arr[0] < arr[1] ? copy[arr[0] * 10 + arr[1]]++ : copy[arr[1] * 10 + arr[0]]++;
        }
        return answer;
    }

}
