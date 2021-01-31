package part_1.medium.ufs;

import java.util.*;

/**
 * description: 1202. 交换字符串中的元素
 */
public class SmallestStringWithSwaps1202 {
    public static void main(String[] args) {
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
