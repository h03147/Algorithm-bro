package part_1.hard.sort;

public class reversePairs_swordOffer51 {

    private int cnt = 0;
    private int[] tmp; // 声明全局辅助数组 方便传递

    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if(h - l < 1) return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);

    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while(i <= m || j <= h) {
            if(i > m) {
                tmp[k] = nums[j++];
            } else if(j > h) {
                tmp[k] = nums[i++];
            } else if(nums[i] <= nums[j]) {
                tmp[k] = nums[i++];
            } else {
                tmp[k] = nums[j++];
                cnt += m - i + 1;  // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j] 左半部分都可以计入结果
            }
            k++;
        }
        for(k = l; k <= h; ++k) {
            nums[k] = tmp[k];
        }
    }

}
