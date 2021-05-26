package part_1.medium.arrayandmatrix;

public class FindDuplicate287 {

    public int findDuplicate(int[] nums) {
        // 方法一 桶排序 用空间换时间
        // int[] cnt = new int[nums.length + 1];
        // for(int num : nums) {
        //     cnt[num]++;
        // }
        // for(int i = 1; i < cnt.length; ++i) {
        //     if(cnt[i] > 1) return i;
        // }
        // return 0;

        // 方法二 二分法 每一次找中间值，考虑到1-n之间的数一定都会出现，如果非重复情况下每个数只会
        // 出现一次，故我们判断小于等于中间值元素个数如果超过了中间值则说明重复的数在左半边，否则去
        // 右半边找
        int low = 1, high = nums.length - 1;
        while(low <= high) {
            int cnt = 0;
            int mid = low + (high - low) / 2;
            for(int i = 0; i < nums.length; ++i) {
                if(nums[i] <= mid) cnt++;
            }
            if(cnt > mid) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

}
