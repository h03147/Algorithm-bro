package part_1.medium.tree;

public class NumTrees96 {

    public int numTrees(int n) {
        /**
         * dp解法，参考官方题解的思路
         */
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
