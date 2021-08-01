package part_1.hard.dp;

public class fib_swordOffer10_1 {

    public int fib(int n) {
        if(n <= 1) return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for(int i = 2; i <= n; ++i) {
            fib = (pre2 + pre1) % 1000000007;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

}
