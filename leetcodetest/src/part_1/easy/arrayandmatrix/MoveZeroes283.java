package part_1.easy.arrayandmatrix;

public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        /*
         * 方法一：直接用一个索引指针，先把非零元素过滤存储到数组前面，保持非零元素相对顺序不变，遍历完毕后
         * 索引指针刚好停留在非零元素末尾位置，后面一直到数组结尾填充0即可。
         * 方法二：向右冒泡排序改编，只比较向右冒牌排序0元素，最终0元素会排在最右边。
         */

        // 方法一 遍历移位法
        // int index = 0;
        // for(int num : nums) {
        //     if(num != 0) {
        //         nums[index++] = num;
        //     }
        // }
        // while(index < nums.length) {
        //     nums[index++] = 0;
        // }

        // 方法二 向右冒泡排序魔改版（只把0向右冒泡）
        int n = nums.length;
        for(int i = n - 1; i > 0; --i) {
            for(int j = 0; j < i; ++j) {
                if(nums[j] == 0 && nums[j + 1] != 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

}
