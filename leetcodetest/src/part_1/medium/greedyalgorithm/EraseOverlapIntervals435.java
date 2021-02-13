package part_1.medium.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals435 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(nums));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        /*
         * 分析题意：先计算最多能组成的不重叠区间个数，然后用区间总个数
         * 减去不重叠区间的个数。在每次选择中，区间的结尾最为重要，选择
         * 的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的
         * 区间个数也就越多。
         * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
         */
        if(intervals.length == 0) {
            return 0;
        }
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                // compare()函数使用时，我们要尽量避免下面这种减法操作，防止溢出
                // return o1[1] - o2[1];
            }
        });
        // 初始时确定首区间
        int count = 1;
        int end = intervals[0][1]; // 首区间的结尾值
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }
}
