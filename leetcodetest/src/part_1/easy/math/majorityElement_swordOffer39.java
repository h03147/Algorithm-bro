package part_1.easy.math;

public class majorityElement_swordOffer39 {

    public int majorityElement(int[] nums) {
        int majority = nums[0], cnt0 = 1;
        for(int i = 1; i < nums.length; ++i) {
            cnt0 = nums[i] == majority ? cnt0 + 1 : cnt0 - 1;
            if(cnt0 == 0) {
                majority = nums[i];
                cnt0 = 1;
            }
        }
        int cnt1 = 0;
        for(int num : nums) {
            if(num == majority) {
                cnt1++;
            }
        }
        return cnt1 > nums.length / 2 ? majority : 0;
    }

}
