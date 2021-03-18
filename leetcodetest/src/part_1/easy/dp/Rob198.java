package part_1.easy.dp;

public class Rob198 {

    public static void main(String[] args) {
        System.out.println(new Rob198().rob(new int[] {1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0]; // 初始情况下，只有一家可以偷
        dp[1] = Math.max(nums[0], nums[1]); // 有两家可以偷的时候，我们就选最大值
        for(int i = 2; i < len; ++i) {
            // 如果偷当前第i家，那就是偷到的i - 2家总金额再加上第i家的金额数，否则就是不偷第i家，那就是只算到
            // i - 1家的总金额
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

}
