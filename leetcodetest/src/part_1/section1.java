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
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        List<Integer> pair1 = new ArrayList<Integer>();
        pair1.add(0);
        pair1.add(3);
        List<Integer> pair2 = new ArrayList<Integer>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair1);
        pairs.add(pair2);
        System.out.println(smallestStringWithSwaps(s, pairs));



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

}
