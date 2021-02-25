package part_1.hard.bfs;

import java.util.*;

public class LadderLength127 {

    public static void main(String[] args) {
        List<String> wordlist = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginword = "hit", endword = "cog";
        System.out.println(ladderLength(beginword, endword, wordlist));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
         * 分析题意：本题要求的是最短转换序列的长度，看到最短首先想到的就是广度优先搜索。想到广度优先搜索
         * 自然而然的就能想到图，但是本题并没有直截了当的给出图的模型，因此我们需要把它抽象成图的模型。我
         * 们可以把每个单词都抽象为一个点，如果两个单词可以只改变一个字母进行转换，那么说明他们之间有一条
         * 双向边。因此我们只需要把满足转换条件的点相连，就形成了一张图。基于该图，我们以 beginWord 为图
         * 的起点，以 endWord 为终点进行广度优先搜索，寻找 beginWord 到 endWord 的最短路径。
         */
        // 以beginword为图的起点，先把他加入到待寻找字典中
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        // 遍历字典，判断目标单词是否在字典中
        while(end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if(end == N) {
            return 0;
        }
        // 存在，则去构建图
        List<Integer>[] graphic = buildGraphic(wordList);
        //图构建完毕后，进行广度优先遍历找到能到达endword的最短过渡序列个数
        return getShortestPath(graphic, start, end);
    }

    private static List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for(int i = 0; i < N; ++i) {
            graphic[i] = new ArrayList<>();
            for(int j = 0; j < N; ++j) {
                // 判断两个单词是否只存在一个字母不相等，即可以成为过渡单词就把他加入到图的节点中
                if(isConntect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private static boolean isConntect(String s1, String s2) {
        int diffCnt = 0;
        // 比对字典中两个单词的每一个字母，筛选出只存在一个字母不用的所有过渡单词
        for(int i = 0; i < s1.length() && diffCnt <= 1; ++i) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    // 对图进行BFS算法，找到最短路径
    private static int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while(size-- > 0) {
                int cur = queue.poll();
                // 在图中找到能进一步接近end的下一个节点位置
                for(int next : graphic[cur]) {
                    if(next == end) {
                        return path;
                    }
                    if(marked[next]) {
                        continue;
                    }
                    // 找到后就做标记加入到最短路径队列中
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
