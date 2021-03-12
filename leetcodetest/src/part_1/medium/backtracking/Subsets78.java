package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        int[] nums = {1, 2, 3};
        System.out.println(subsets78.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for(int size = 0; size <= nums.length; ++size) {
            // 所有子集的长度可能为0到nums.length，每一个可能长度size我们都要dfs并且回溯他所有可能的排列组合
            backTracking(0, size, nums, tempSubset, allSubsets);
        }
        return allSubsets;
    }

    private void backTracking(int start, int size, int[] nums, List<Integer> tempSubset, List<List<Integer>> allSubsets) {
        if(tempSubset.size() == size) {
            allSubsets.add(new ArrayList<>(tempSubset));
            return;
        }

        for(int i = start; i < nums.length; ++i) {
            tempSubset.add(nums[i]);
            backTracking(i + 1, size, nums, tempSubset, allSubsets);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }

}
