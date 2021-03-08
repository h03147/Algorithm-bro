package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique47 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }


    // 方法一 HashSet 暴力去重
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     Set<List<Integer>> permuteUniqueSet = new HashSet<>();
    //     List<Integer> permuteUniqueList = new ArrayList<>();
    //     boolean[] hasVisited = new boolean[nums.length];
    //     backTracking(nums, hasVisited, permuteUniqueList, permuteUniqueSet);
    //     List<List<Integer>> permuteUniqueResult = new ArrayList<>(permuteUniqueSet);
    //     return permuteUniqueResult;
    // }

    // private void backTracking(int[] nums, boolean[] hasVisited, List<Integer> permuteUniqueList, Set<List<Integer>> permuteUniqueSet) {
    //     if(permuteUniqueList.size() == nums.length) {
    //         permuteUniqueSet.add(new ArrayList<>(permuteUniqueList));
    //         return;
    //     }

    //     for(int i = 0; i < hasVisited.length; ++i) {
    //         if(hasVisited[i]) {
    //             continue;
    //         }
    //         hasVisited[i] = true;
    //         permuteUniqueList.add(nums[i]);
    //         backTracking(nums, hasVisited, permuteUniqueList, permuteUniqueSet);
    //         permuteUniqueList.remove(permuteUniqueList.size() - 1);
    //         hasVisited[i] = false;
    //     }
    // }

    // 方法二 手动判断去重
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permuteUniqueResult = new ArrayList<>();
        List<Integer> permuteUniqueList = new ArrayList<>();
        Arrays.sort(nums); // 先排序
        boolean[] hasVisited = new boolean[nums.length];
        backTracking(nums, hasVisited, permuteUniqueList, permuteUniqueResult);
        return permuteUniqueResult;
    }

    private static void backTracking(int[] nums, boolean[] hasVisited, List<Integer> permuteUniqueList, List<List<Integer>> permuteUniqueResult) {
        if(permuteUniqueList.size() == nums.length) {
            permuteUniqueResult.add(new ArrayList<>(permuteUniqueList));
            return;
        }

        for(int i = 0; i < hasVisited.length; ++i) {
            // 手动判断去重
            if(i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if(hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            permuteUniqueList.add(nums[i]);
            backTracking(nums, hasVisited, permuteUniqueList, permuteUniqueResult);
            permuteUniqueList.remove(permuteUniqueList.size() - 1);
            hasVisited[i] = false;
        }
    }

}
