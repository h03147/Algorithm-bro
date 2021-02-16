package part_1.easy.greedyalgorithm;

public class CheckPossibility665 {

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        /*
         * 分析题目，首先按照提议，只改变数组中其中一个数字的值，让整个数组变成非递减顺序
         * 本体需要找到尽可能少的实例来覆盖出所有满足题意的排列顺序
         * 找到如下三种情况可以覆盖所有情况
         * 1. [4, 2, 3]
         * 2. [-1, 4, 2, 3]
         * 3. [4, 5, 5, 4, 6]
         * 我们发现定位到位置i，有两种情况需要分析：
         * 要么修改i - 1 位置上的数为i位置上的数， 要么修改i位置上的数为i - 1 位置上的数即可满足条件
         * 例子1， i 为 2 , i - 1为4，4前面不再有数字了，修改i - 1位置上的4为i位置上的2即可
         * 例子2， i 为 2 , i - 1为4, i - 1 前面的i - 2 位置上还有数 -1, 切-1 < 4 < 2, 则还是让i - 1
         * 位置上的4改为i位置上的2即可
         * 例子3，i位置上是4，我们发现不仅i - 1 位置上5 > 4, 而且i - 2 位置上5也大于4，这种情况下，我们
         * 需要把i位置上的4修改成i - 1 位置上的值5即可
         * 除以上三种情况返回结果是true外，其他情况返回结果均为false
         */

        if(nums == null || nums.length <= 1) {
            return true;
        }
        int move_count = 0;
        for(int i = 1; i < nums.length && move_count < 2; ++i) {
            if(nums[i - 1] <= nums[i]) {
                continue;
            }

            move_count++;
            // if 例3的情况 else 例1和例2的情况
            if(i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return move_count <= 1;
    }
}
