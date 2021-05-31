package part_1.medium.arrayandmatrix;

public class MaxChunksToSorted769 {

    public int maxChunksToSorted(int[] arr) {
        /*
         * 分析题意：当遍历到第 i 个位置时，如果可以切成快，那满足前 i + 1 个元素的最大值一定等于i。
         * 否则一定有比 i 还要小的数组值被强制划分到后面的块去了，这样排序出来的各个块连起来
         * 不满足全局升序。
         */
        int ans = 0;
        int maxNum = arr[0];
        for(int i = 0; i < arr.length; ++i) {
            maxNum = Math.max(maxNum, arr[i]); // 统计前 i + 1 个元素中的最大元素
            if(maxNum == i) ans++;
        }
        return ans;
    }

}
