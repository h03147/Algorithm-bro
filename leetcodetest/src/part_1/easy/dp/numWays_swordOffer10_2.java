package part_1.easy.dp;

public class numWays_swordOffer10_2 {

    public int numWays(int n) {
        // if(n == 0) return 1;
        // if(n <= 2) return n;
        // int pre2 = 1, pre1 = 2, ret = 0;
        // for(int i = 2; i < n; ++i) {
        //     ret = (pre2 + pre1) % 1000000007;
        //     pre2 = pre1;
        //     pre1 = ret;
        // }
        // return ret;

        int pre2 = 1, pre1 = 1, ret = 0;
        for(int i = 0; i < n; ++i) {
            ret = (pre2 + pre1) % 1000000007;
            pre2 = pre1;
            pre1 = ret;
        }
        return pre2;
    }

}
