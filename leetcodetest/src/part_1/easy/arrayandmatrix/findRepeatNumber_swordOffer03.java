package part_1.easy.arrayandmatrix;

public class findRepeatNumber_swordOffer03 {

    public int findRepeatNumber(int[] nums) {
        // // 方法一 排序后滑动找相邻的数组
        // Arrays.sort(nums);
        //     // System.out.println(Arrays.toString(nums));
        // int result = -1;
        // for(int i = 1; i < nums.length; ++i) {
        //     if(nums[i - 1] == nums[i]) {
        //         result = nums[i];
        //         break;
        //     }
        // }
        // return result;

        // 方法二 原地判断 nums[i] = i, 是否成立，如果成立就继续遍历后面的数，不成立就进一步找 index = nums[i]
        // 位置的 nums[index] = nums[i] 是否成立，如果成立，则找到了重复的数就是nums[i]，否则把nums[i] 放到下标
        // index为nums[i] 的位置去，让此位置的下标index和其对应的数组值相等，相当于排序了一趟把他放在有序的位置，
        // 下一次再次找到重复的数组值，又去下标index为数组值的位置上去找，发现两个数组值相等，说明重复了，返回结果。
        for(int i = 0; i < nums.length; ++i) {
            while(nums[i] != i) {
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
