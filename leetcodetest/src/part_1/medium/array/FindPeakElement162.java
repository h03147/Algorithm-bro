package part_1.medium.array;

public class FindPeakElement162 {

    public int findPeakElement(int[] nums) {
        // // O(n) 时间复杂度不满足题意
        // int maxNumIdx = 0, maxNum = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.length; ++i) {
        //     if(nums[i] > maxNum) {
        //         maxNum = nums[i];
        //         maxNumIdx = i;
        //     }
        // }
        // return maxNumIdx;

        // O(log n) 时间复杂度(二分法)
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
