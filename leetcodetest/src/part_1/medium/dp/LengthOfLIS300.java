package part_1.medium.dp;

public class LengthOfLIS300 {

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i) {
            //初始情况下，递增子序列长度最小为1
            int max = 1;
            // 遍历找所有下标小于等于i的数，作比较找到尽可能多的严格递增子序列
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) {
                    // 找到了一个，nums[i] 比前序转移方程dp[j]的最大值还要大，说明递增子序列可以再加1
                    max = Math.max(max, dp[j] + 1);
                }
            }
            // 每一趟下标小于等于i的子序列遍历都能找到以i为结尾下标的最大递增子序列长度
            dp[i] = max;
        }

        // 最后遍历找到最大的dp[i]即为结果
        // return Arrays.stream(dp).max().orElse(0);

        int result = 0;
        for(int i = 0; i < n; ++i) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
