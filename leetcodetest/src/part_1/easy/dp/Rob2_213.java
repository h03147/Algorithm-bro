package part_1.easy.dp;

import java.util.Arrays;

public class Rob2_213 {

    public static void main(String[] args) {
        System.out.println(new Rob2_213().rob(new int[] {1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        // 分析题意：这个问题是之前单排房子偷盗的升级版，但是我们可以把这个环形的房子街区
        // 拆分成两个之前单排街区来按照之前的动态规划方法进行偷盗，然后再并到一起找最大值
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, n - 1)), myRob(Arrays.copyOfRange(nums, 1, n)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, temp;
        for(int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

}
