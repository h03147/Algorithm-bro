package part_1.easy.twopoint;

import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence_swordOffer57 {

    public int[][] findContinuousSequence(int target) {
        /**
         * 分析题意：我们用两个指针 l 和 r 表示当前枚举到的以 l 为起点到 r 的区间，sum 表示 [l,r] 的区间和，由求和公式可 O(1) 求得为
         * sum = (l + r) * (r - l + 1) / 2 ，起始 l=1,r=2。
         *
         * 一共有三种情况：
         *
         * 如果 sum<target 则说明指针 r 还可以向右拓展使得 sum 增大，此时指针 r 向右移动，即 r+=1
         * 如果 sum>target 则说明以 l 为起点不存在一个 r 使得 sum=target ，此时要枚举下一个起点，指针 l 向右移动，即l+=1
         * 如果 sum==target 则说明我们找到了以 l 为起点得合法解 [l,r] ，我们需要将 [l,r] 的序列放进答案数组，且我们知道以
         * l 为起点的合法解最多只有一个，所以需要枚举下一个起点，指针 l 向右移动，即 l+=1
         * 终止条件即为 l>=r 的时候，这种情况的发生指针 r 移动到了 (target/2) + 1 的位置，导致 l<r 的时候区间和始终大于 target。
         * 这个l指针是左边界，而r指针是右边界，有滑动窗口那味道了，只是这个窗口长度是动态变化的。
         */
        List<int[]> outRet = new ArrayList<>();
        for(int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if(sum == target) {
                int[] res = new int[r - l + 1];
                for(int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                outRet.add(res);
                l++;
            } else if(sum < target) {
                r++;
            } else {
                l++;
            }
        }
        System.out.println(outRet);
        return outRet.toArray(new int[outRet.size()][]);
    }

}
