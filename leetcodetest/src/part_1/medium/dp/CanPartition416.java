package part_1.medium.dp;

public class CanPartition416 {

    public static void main(String[] args) {
        System.out.println(new CanPartition416().canPartition(new int[] {1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = generateArraySum(nums);
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // 0-1 背包一个物品只能用一次
        for(int num : nums) {
            // 从后先前，先计算 dp[i] 在计算 dp[i - num]
            for(int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    private int generateArraySum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }

}
