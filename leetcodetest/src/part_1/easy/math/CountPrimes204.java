package part_1.easy.math;

public class CountPrimes204 {

    public static void main(String[] args) {
        System.out.println(new CountPrimes204().countPrimes(10));
    }

    // // 方法一 枚举 加 优化时间复杂度为O(sqrt(n));
    // public int countPrimes(int n) {
    //     int answer = 0;
    //     for(int i = 2; i < n; ++i) {
    //         answer += isPrime(i) ? 1 : 0;
    //     }
    //     return answer;
    // }

    // private boolean isPrime(int x) {
    //     for(int i = 2; i <= (int) Math.sqrt(x); ++i) {
    //         if(x % i == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // 方法二 埃拉托斯特尼筛法
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int count = 0;
        for(int i = 2; i < n; ++i) {
            if(notPrime[i]) {
                continue;
            }
            count++;
            // 在每次找到一个素数时，将能被素数整除的数排除掉
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for(long j = (long) i * i; j < n; j += i) {
                notPrime[(int) j] = true;
            }
        }
        return count;
    }

}
