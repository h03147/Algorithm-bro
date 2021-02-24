package part_1.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquares279 {


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }


    public static int numSquares(int n) {
        /*
         * 分析题意：可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么
         * 这两个整数所在的节点就有一条边。要求解最小的平方数数量，就是求解从节点 n 到节
         * 点 0 的最短路径。
         */
        // 找到小于等于n的所有平方数
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        // 所有访问过的数做标记
        boolean[] marked = new boolean[n + 1];
        queue.offer(n);
        marked[n] = true;
        int level = 0; // 当前在第零层
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- > 0) {
                int cur = queue.poll();
                for(int s : squares) {
                    // 下一个可能的数（节点）
                    int next = cur - s;
                    if(next < 0) {
                        break;
                    }
                    if(next == 0) {
                        return level;
                    }
                    if(marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.offer(next);
                }
//                for(int i : queue) {
//                    System.out.print(i + ", ");
//                }
//                System.out.println();
            }
        }
        return n;
    }

    // 找到所有比n小的平方数序列方法
    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        // 第一个平方数
        int square = 1;
        // 下一个平方数的增量
        int diff = 3;
        while(square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
