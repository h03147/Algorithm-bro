package part_1.easy.binarysearch;

public class MySqrt69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        // // 方法一 请神法
        // return (int)Math.sqrt(x);
        /*
         * 分析题意：首先我们求的是开平方根，取值范围肯定是（0， x）范围内的，
         * 如果我们从大到小一个一个遍历，绝对的浪费时间，因为随着数越来越大，这
         * 个数的开平方只会在x的一半的左边越来越左，所以我们可以考虑用二分法来比
         * 较求值可以减少不必要的比较。
         */

        // 首先x小于等于1时是特例，单独判断
        if(x <= 1) {
            return x;
        }

        int low = 1, high = x;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = x / mid;
            if(sqrt == mid) {
                return mid;
            } else if(mid > sqrt) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // 循环结束条件是high位置比low位置小一位，而本题取整舍去小数部分，故取左值high
        return high;
    }
}
