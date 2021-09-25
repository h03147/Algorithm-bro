package part_1.easy.array;

public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }

}
