package part_1.medium.dp;

import java.util.ArrayList;
import java.util.List;

public class NumSquares279 {


    public static void main(String[] args) {
        System.out.println(new NumSquares279().numSquares(13));
    }

    public int numSquares(int n) {
        //     // 方法一 bfs
        //     /*
        //     * 分析题意：可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么
        //     * 这两个整数所在的节点就有一条边。要求解最小的平方数数量，就是求解从节点 n 到节
        //     * 点 0 的最短路径。
        //     */
        //     // 找到小于等于n的所有平方数
        //     List<Integer> squares = generateSquares(n);
        //     Queue<Integer> queue = new LinkedList<>();
        //     // 所有访问过的数做标记
        //     boolean[] marked = new boolean[n + 1];
        //     queue.offer(n);
        //     marked[n] = true;
        //     int level = 0; // 当前在第零层
        //     while(!queue.isEmpty()) {
        //         int size = queue.size();
        //         level++;
        //         while(size-- > 0) {
        //             int cur = queue.poll();
        //             for(int s : squares) {
        //                 // 下一个可能的数（节点）
        //                 int next = cur - s;
        //                 if(next < 0) {
        //                     break;
        //                 }
        //                 if(next == 0) {
        //                     return level;
        //                 }
        //                 if(marked[next]) {
        //                     continue;
        //                 }
        //                 marked[next] = true;
        //                 queue.offer(next);
        //             }
        //         }
        //     }
        //     return n;
        // }

        // // 找到所有比n小的平方数序列方法
        // private List<Integer> generateSquares(int n) {
        //     List<Integer> squares = new ArrayList<>();
        //     // 第一个平方数
        //     int square = 1;
        //     // 下一个平方数的增量
        //     int diff = 3;
        //     while(square <= n) {
        //         squares.add(square);
        //         square += diff;
        //         diff += 2;
        //     }
        //     return squares;
        // }


        // 方法二 动态规划
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for(int square : squareList) {
                if(i < square) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while(square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

}
