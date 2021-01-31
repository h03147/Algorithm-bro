package part_1.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 189. 旋转数组
 */
public class Rotate189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k =3;
        System.out.println(rotate(nums, k));;
    }

    public static List<Integer> rotate(int[] nums, int k) {
        // // 方法一
        // int n = nums.length;
        // int[] newarr = new int[n];
        // for(int i = 0; i < n; ++i) {
        //     newarr[(i + k) % n] = nums[i];
        // }
        // System.arraycopy(newarr, 0, nums, 0, n);

        // 方法二 三次原地自转
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        List<Integer> nums2list = new ArrayList<Integer>();
        for(int item : nums) {
            nums2list.add(item);
        }
        return nums2list;
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp = nums[start];
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
