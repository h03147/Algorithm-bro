package part_1.medium.array;

public class MaxArea11 {

    public int maxArea(int[] height) {
        /*
         * 分析题意：双指针从两端向中间夹起来求面积，高度小的指针向内
         * 移动，高度高的指针保持不动。
         * 思考一个问题：为什么只移动高度小的指针？
         * 因为当两个指针靠近时，他们之间的距离就在缩短，你再让当前高
         * 度更高的指针向内移动，那必定面积只会更小，相反你让高度小的
         * 指针向内移动还有可能碰到更高的指针，让其面积更大。
         */
        int n = height.length;
        int i = 0, j = n - 1, maxNum = 0;
        while(i < j) {
            maxNum = Math.max(maxNum, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxNum;
    }

}
