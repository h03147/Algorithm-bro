package part_1.easy.arrayandmatrix;

public class FindMaxConsecutiveOnes485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for(int num : nums) {
            cur = num == 1 ? cur + 1 : 0;
            max = Math.max(max, cur);
        }
        return max;
    }

}
