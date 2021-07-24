package part_1.easy.binarysearch;

public class minArray_swordOffer11 {

    public int minArray(int[] numbers) {
        /**
         * 分析题意：此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组。我们很容易
         * 知道非递减数组的第一个元素一定小于等于最后一个元素。
         *
         * 通过修改二分查找算法进行求解（l 代表 low，m 代表 mid，h 代表 high）：
         *
         * 当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，
         * 此时令 h = m；否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
         */
        if(numbers.length == 0) return 0;
        int l = 0, h = numbers.length - 1;
        while(l < h) {
            int m = l + (h - l) / 2;
            // 如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，此时无法确定
            // 解在哪个区间，需要切换到顺序查找。
            if(numbers[l] == numbers[m] && numbers[m] == numbers[h]) {
                return minNumber(numbers, l, h);
            } else if(numbers[m] > numbers[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return numbers[l];
    }

    private int minNumber(int[] numbers, int l, int h) {
        for(int i = l; i < h; ++i) {
            if(numbers[i]> numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[l];
    }

}
