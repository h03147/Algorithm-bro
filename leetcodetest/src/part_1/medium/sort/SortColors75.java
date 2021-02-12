package part_1.medium.sort;

import java.util.ArrayList;
import java.util.List;

public class SortColors75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        List<Integer> result_array2list = new ArrayList<>();

        sortColors(nums);

        for(int item : nums) {
            result_array2list.add(item);
        }
        System.out.println(result_array2list);
    }

    public static void sortColors(int[] nums) {
        // 方法一 hashMap遍历求解
        // HashMap<Integer, Integer> hashMap = new HashMap<>();
        // for(int num : nums) {
        //     hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        // }

        // int count = 0;
        // for(int key : hashMap.keySet()) {
        //     int value = hashMap.get(key);
        //     for(int i = 0; i < value; ++i) {
        //         nums[count++] = key;
        //     }
        // }

        // 方法二 三向切分快速排序
        /*
         * 经典荷兰国旗问题：荷兰国旗包含三种颜色：红、白、蓝。给你一个任意混乱但只包含这三种颜色的数组，
         * 让你用算法将其颜色按照红、白、蓝的先后顺序排列好，这里我们叫做三项切分快速排序，每次切分都是
         * 将数组分成三个区域：小于切分元素，等于切分元素，大于切分元素，而该算法时间数组分成三个区域：
         * 等于红色、等于白色、等于蓝色。（本题用到0，1，2三个数代替）
         */

        // 设三个变量，zero表示第一段，one表示第二段也是当前正在遍历的下标位置，同时也叫左指针，tow表示
        // 第三段，指向数组的结尾（也叫右指针）
        int zero = -1, one = 0, two = nums.length;
        while(one < two) {
            if(nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if(nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                one++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
