package part_1.medium.binarysearch;

public class SingleNonDuplicate540 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        /*
         * 分析题意：给了一个有序数组，里面有且只有一个元素是唯一的，其他
         * 元素都是成对的捆绑出现的。让我们把那个single element找出来并
         * 返回输出。注意要求：时间复杂度是O(log n), 空间复杂度O（1）。
         *
         * 数组有序，在其中找一个存在的元素，时间复杂度要低于线性的，我们
         * 首当其中想到了就是二分查找法，呢媒体中我们要找的这个一个规律，就
         * 是二分法要找的那个唯一的元素我们都不知道是哪一个，所以我们需要要
         * 确定那个唯一元素当前实在我们折半索引位置的左边还是右边，我们才能
         * 决定下一步应该向哪一边取折半缩小范围。

         * 进一步分析我们发现，如果当正在折半查找的索引位置m是一个偶数，我们
         * 设single element元素的下标为index，那么如果m + 1索引位置小于index
         * （m + 1 < index），那么就有nums[m] = nums[m + 1]。反之如果当前
         * m + 1位置索引大于等于index（m + 1 >= index）,则有muns[m] != nums[m + 1]。
         *
         * 元音其实很好理解，当这个只有一个的唯一元素single element 没有加进来
         * 时，数组里面元素总个数时偶数，但这个元素加进来后，数组长度就变成了奇数，
         * 那么从当前加进来这个元素开始，之后所有的元素索引下标都错位了，导致当m为
         * 偶数下标时，nums[m] != num[m + 1]。
         * 根据这个规律，我们就知道每一个折半应该向哪个反向取缩小范围了。
         */

        int low = 0, high = nums.length - 1;
        // 考虑当前要向左折半时，有h = m会出现，故while循环条件相等的这种情况要去掉，否则会死循环
        // 可以记一下一个规律，在一个有重复元素出现的数组中我们的判断条件low不能等于high
        while(low < high) {
            int m = low + (high - low) / 2;
            if(m % 2 == 1) {
                m--; // 让当前m索引位置一定是偶数。
            }
            if(nums[m] == nums[m + 1]) {
                low = m + 2;
            } else {
                high = m;
            }
        }
        return nums[low];
    }
}
