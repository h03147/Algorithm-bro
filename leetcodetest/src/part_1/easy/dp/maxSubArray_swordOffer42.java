package part_1.easy.dp;

public class maxSubArray_swordOffer42 {

    public int maxSubArray(int[] nums) {
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            sum = sum <= 0 ? num : sum + num;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

}
