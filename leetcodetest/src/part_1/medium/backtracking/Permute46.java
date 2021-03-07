package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permuteResult = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        backTracking(nums, hasVisited, permuteList, permuteResult);
        return permuteResult;
    }

    private static void backTracking(int[] nums, boolean[] hasVisited, List<Integer> permuteList, List<List<Integer>> permuteResult) {
        if(permuteList.size() == nums.length) {
            permuteResult.add(new ArrayList<>(permuteList)); // 重构一个List
            return;
        }

        for(int i = 0; i < hasVisited.length; ++i) {
            if(hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            permuteList.add(nums[i]);
            backTracking(nums, hasVisited, permuteList, permuteResult);
            permuteList.remove(permuteList.size() - 1);
            hasVisited[i] = false;
        }


    }

}
