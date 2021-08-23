package part_1.medium.other;

public class isStraight_swordOffer61 {

    public boolean isStraight(int[] nums) {
        if(nums.length < 5) return false;
        Arrays.sort(nums);

        // 统计癞子的个数
        int cnt = 0;
        for(int num : nums) {
            if(num == 0) {
                cnt++;
            }
        }

        for(int i = cnt; i < nums.length - 1; ++i) {
            if(nums[i + 1] == nums[i]) {
                return false;
            }
            // 尝试用癞子个数去抵消掉两个不连续数之间的差值
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        // 癞子刚好补完或者有多的都满足题意
        return cnt >= 0;
    }

}
