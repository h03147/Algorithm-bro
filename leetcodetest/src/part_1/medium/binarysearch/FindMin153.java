package part_1.medium.binarysearch;

public class FindMin153 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        // 方法一
        // Arrays.sort(nums);
        // return nums[0];

        // 方法二 找到当前第一个比前置节点小的数就是最小值
        // int pre = nums[0], size = nums.length;
        // if(size == 1) {
        //     return nums[0];
        // }
        // for(int i = 1; i < size; ++i) {
        //     if(nums[i] < pre) {
        //         return nums[i];
        //     } else {
        //         pre = nums[i];
        //     }
        // }
        // return nums[0];

        // 方法三 二分查找法
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
