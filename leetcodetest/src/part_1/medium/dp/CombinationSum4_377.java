package part_1.medium.dp;

import java.util.Arrays;

public class CombinationSum4_377 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new CombinationSum4_377().combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        // 外层背包容量i
        for(int i = 1; i <= target; ++i) {
            // 内层物品遍历nums找到所有可能的不超过容量i的物品装进去，累加所有能得到的组合
            for(int j = 0; j < nums.length && nums[j] <= i; ++j) {
                dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        return dp[target];
    }

}
