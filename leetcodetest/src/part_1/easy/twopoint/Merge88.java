package part_1.easy.twopoint;

import java.util.ArrayList;
import java.util.List;

public class Merge88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        merge(nums1, 3 , nums2, 3);
        List<Integer> nums2list = new ArrayList<>();
        for(int item : nums1) {
            nums2list.add(item);
        }
        System.out.println(nums2list);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // for(int num : nums2) {
        //     nums1[m++] = num;
        // }
        // Arrays.sort(nums1);
        /*
         * 分析题意：nums1数组已经提前给nums2数组预留了空间，出题人肯定是想让我们
         * 原地操作，不要再开辟额外的空间。既然知识点是双指针，我们就用双指针，但是
         * 这一题双指针肯定是两个数组一人一个，然后遍历比较对吧，那么这里指针的位置
         * 就很有讲究，假设两个数字都从头开始边遍历便比较，那么可能nums1中每个元素
         * 的位置都要挪动一下，如果我们反过来想，数组nums1中已经给nums2提前预留了
         * 空位置，空位置就不存在挪动了，而是直接过去坐下就行了，这样是不是就避免了
         * 不必要的位置挪动，所以我们就用都从两个数组有值的最大的尾巴位置开始遍历比
         * 较就可以了
         */
        int p1_high = m - 1, p2_high = n - 1;
        int merge_range = m + n - 1;
        while(p1_high >=0 || p2_high >= 0) {
            if(p1_high < 0) {
                nums1[merge_range--] = nums2[p2_high--];
            } else if(p2_high < 0) {
                nums1[merge_range--] = nums1[p1_high--];
            } else if(nums1[p1_high] > nums2[p2_high]) {
                nums1[merge_range--] = nums1[p1_high--];
            } else {
                nums1[merge_range--] = nums2[p2_high--];
            }
        }
    }
}
