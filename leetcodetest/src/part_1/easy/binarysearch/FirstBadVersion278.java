package part_1.easy.binarysearch;

public class FirstBadVersion278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        /*
         * 分析题意：我们可以把需要查找的数组，想象成一个只有true和false两个值
         * 出现的boolean型数组，而且只要我们在搜索中找到一个true出现，代表从这
         * 个位置开始先后全部都是错误版本，返回结果一定都是true，这题我们依旧使
         * 用二分查找法来求解。既然当前版本右边都是错误版本，故我们需要判断，当前
         * 错误版本的左边是否存在比它更旧的版本也出现错误，即折半左区间[low, mid]
         *，而当前mid的值是false的时候，就说明第一个错误的版本一定在mid有边且不包
         * 括mid，即[mid + 1, n]的区间。
         */

        int low = 1, high = n;
        // 因为向左折半的时候high = m故while循环相等情况要去掉
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isBadVersion(int x){
        boolean[] nums = {false, false, false, true, true};
        return nums[x - 1];
    }
}
