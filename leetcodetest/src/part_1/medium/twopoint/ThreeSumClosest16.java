package part_1.medium.twopoint;

public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;

}
