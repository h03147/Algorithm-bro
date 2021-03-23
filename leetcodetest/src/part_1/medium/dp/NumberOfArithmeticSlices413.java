package part_1.medium.dp;

public class NumberOfArithmeticSlices413 {

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices413().numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 2; i < n; ++i) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // 因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果
        int total = 0;
        for(int count : dp) {
            total += count;
        }

        return total;
    }
}
