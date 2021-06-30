package part_1.easy.twopoint;

public class twoSum_swordOffer57 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                return new int[] {nums[i], nums[j]};
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0, 0};
    }

}
