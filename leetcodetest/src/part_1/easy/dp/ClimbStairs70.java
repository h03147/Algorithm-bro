package part_1.easy.dp;

public class ClimbStairs70 {


    public static void main(String[] args) {
        int n = 4;
        System.out.println(new ClimbStairs70().climbStairs(n));
    }

    public int climbStairs(int n) {
        // 方法一 递归实现 超时不可行！
        // if(n == 1) {
        //     return 1;
        // }
        // if(n == 2) {
        //     return 2;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // 方法二 优化递归 去重复
        // int[] visited = new int[n + 1];
        // return climbStairsVisited(n, visited);

        // 方法三 动态规划
        // f(n) = f(n - 1) + f(n - 2)
        // 滚动数组的思想
        int pre1 = 0, pre2 = 0, rank = 1;
        for(int i = 1; i <= n; ++i) {
            pre1 = pre2;
            pre2 = rank;
            rank = pre1 + pre2;
        }
        return rank;
    }

    // private int climbStairsVisited(int n, int[] visited) {
    //     if(visited[0] > 0) {
    //         return visited[0];
    //     }
    //     if(n == 1) {
    //         visited[n] = 1;
    //     } else if(n == 2) {
    //         visited[n] = 2;
    //     } else {
    //         visited[n] = climbStairsVisited(n - 1, visited) + climbStairsVisited(n - 2, visited);
    //     }

    //     return visited[n];
    // }

}
