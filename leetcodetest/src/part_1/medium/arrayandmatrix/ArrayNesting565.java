package part_1.medium.arrayandmatrix;

public class ArrayNesting565 {

    public int arrayNesting(int[] nums) {
        /*
         * 分析题意：本题思想上有贪心算法那味道，也就是每一个元素都去尝试嵌套搜索，每搜索一个就让统计长度加一
         * 同时访问过的元素都覆盖为-1做标记，代表访问过了，这样做的好处可以减少重复的访问。每一个位置上能搜索
         * 最深的嵌套深度和前序的maxNest做比较，大就替换，最后遍历完一遍数组，maxNest就是最大集合了
         */
        int maxNest = 0;
        for(int i = 0; i < nums.length; ++i) {
            int cnt = 0;
            for(int j = i; nums[j] != -1;) {
                cnt++;
                int t = nums[j];
                nums[j] = -1; // 标识为已访问了
                j = t;
            }
            maxNest = Math.max(maxNest, cnt);
        }
        return maxNest;
    }

}
