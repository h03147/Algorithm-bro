package part_1.easy.sort;

public class exchange_swordOffer21 {

    // 方法一 复制nums数组同样大小空间的数组copy，双指针原地修改nums中的数值至满足题意
    // 空间换时间
    public int[] exchange(int[] nums) {
        int oddCnt = 0;
        for(int num : nums) {
            if(!isEven(num)) {
                oddCnt++;
            }
        }
        int i = 0, j = oddCnt;
        int[] copy = nums.clone();
        for(int num : copy) {
            if(num % 2 == 0) {
                nums[j++] = num;
            } else {
                nums[i++] = num;
            }
        }
        return nums;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    // // 方法二 冒泡排序 遍历一遍 每次都要是偶数的数向右冒泡到最右边(O(n^2) 时间复杂度超出时间限制)
    // public int[] exchange(int[] nums) {
    //     int N = nums.length;
    //     for(int i = N - 1; i > 0; --i) {
    //         // 每趟内层循环都能让一个最大的偶数右冒泡出去
    //         for(int j = 0; j < i; ++j) {
    //             if(isEven(nums[j]) && !isEven(nums[j + 1])) {
    //                 swap(nums, j, j + 1);
    //             }
    //         }
    //     }
    //     return nums;
    // }

    // private boolean isEven(int num) {
    //     return num % 2 == 0;
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

}
