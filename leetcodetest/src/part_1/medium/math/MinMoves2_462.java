package part_1.medium.math;

import java.util.Arrays;

public class MinMoves2_462 {

    public static void main(String[] args) {
        System.out.println(new MinMoves2_462().minMoves2(new int[] {1, 2, 3}));
    }

    public int minMoves2(int[] nums) {
        // 中位数距离最短证明
        // 概括:
        // 给定数轴上的n个点，找出一个到它们的距离之和尽量小的点
        // 结论:这些点的中位数就是目标点。
        // 证明:
        // o o o o 灰点 o o
        // 任意找一个点，比如图中的大灰点,它的左边有4个点，右边两个。
        // 现在我们尝试把它移动一点，比较距离和。
        // 1.向左移一点点,假设移动了x距离,则灰点左边4个点到它的距离各减少了x，总共减少s1=4x
        // 灰点右边两个点到它的距离各增加了x，总共增加s2=2x；6个点的距离和减少了4x-2x=2x;
        // 换句话说，向左移的解更优。
        // 2.向右移一点点，同上分析，得到的解会增加2x,不会更优
        // 如果灰点左边两个点，右边4个，道理类似，不过应该向右移才能得到更优解。
        // 左边2个右边4个要向右移；左边4个，右边2个又要向左移。
        // 所以只有当灰点左右两边点一样多才是最优解。

        // // 方法一 直接取到中位数的绝对值
        // Arrays.sort(nums);
        // int move_count = 0, mid = nums.length / 2;
        // for(int num : nums) {
        //     move_count += Math.abs(nums[mid] - num);
        // }
        // return move_count;

        // 方法二 二分法按对数距离相加 (1, n),(2, n - 1),(3, n - 2)...
        Arrays.sort(nums);
        int move_count = 0;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            move_count += nums[high] - nums[low];
            low++;
            high--;
        }
        return move_count;
    }

}
