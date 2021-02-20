package part_1.medium.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchRange34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        List<Integer> result_list = new ArrayList<>();
        int[] result_array = searchRange(nums, 8);
        for(int num : result_array) {
            result_list.add(num);
        }
        System.out.println(result_list);
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirst(nums, target);
        int lastIndex = findFirst(nums, target + 1) - 1;
        if(firstIndex == nums.length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{firstIndex, lastIndex};
        }
    }

    // 二分查找方法封装 查找target第一次出现的位置
    private static int findFirst(int[] nums, int target) {
        // 这里high取值比数组下标最大值大1，因为考虑如果当前target不存在
        // 于数组中我们九八他插入到最后一个位置之后。因为这里我们要找到target
        // 最后一次出现的位置，我们的做法是先找到比target大1也就是target + 1
        // 的第一次出现的位置，然后减去1就是target最后一次出现的位置了。

        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
