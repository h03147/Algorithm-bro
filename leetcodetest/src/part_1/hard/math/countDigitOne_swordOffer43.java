package part_1.hard.math;

public class countDigitOne_swordOffer43 {

    public int countDigitOne(int n) {
        /**
         * 分析题意：// 根据当前位的大小进行判断，比如数字 135x21
         * 如果遍历到百位，百位的数字x，x 需要分三种情况讨论
         * 第一种：等于1，那么在百位可以计算1的个数为 135 * 100 + 21
         * 第二种：大于等于 2，在百位可以计算出1的个数为 (135+1)*100
         * 第三种：小于 1,在百位计数出1的个数为 135*100
         * 所以大致的思路就是：遍历到哪一位时，将数字分为两部分，然后叠加每一位出现1的次数
         */
        int count = 0;
        for(long pos = 1; pos <= n; pos *= 10){
            int big = n / (int)pos;
            int small = n %  (int)pos;
            // if(big % 10 == 1){
            //     count += small + 1;
            // }
            // // 之所以这样写，是把第二种和第三种合在了一起
            // // 如果因为如果大于2，加8一定会进一位，如果小于等于，就算+8，也不会产生影响
            // count += (big + 8) / 10 * pos;

            count += (big + 8) / 10 * pos + (big % 10 == 1 ? small + 1 : 0);
        }
        return count;
    }

}
