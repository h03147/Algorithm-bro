package part_1.easy.bitwiseoperator;

public class hammingWeight_swordOffer15 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

}
