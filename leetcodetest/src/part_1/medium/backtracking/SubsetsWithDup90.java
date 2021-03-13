package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {

    public static void main(String[] args) {
        SubsetsWithDup90 subsetsWithDup90 = new SubsetsWithDup90();
        System.out.println(subsetsWithDup90.subsetsWithDup(new int[] {1, 2, 2}));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetsWithDups = new ArrayList<>();
        List<Integer> subsetList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        // 每个长度的子集都有多种组合
        for(int size = 0; size <= nums.length; ++size) {
            backTracking(0, size, hasVisited, subsetList, subsetsWithDups, nums);
        }
        return subsetsWithDups;
    }

    private void backTracking(int start, int size, boolean[] hasVisited, List<Integer> subsetList, List<List<Integer>> subsetsWithDups, int[] nums) {
        if(subsetList.size() == size) {
            subsetsWithDups.add(new ArrayList<>(subsetList));
            return;
        }

        for(int i = start; i < nums.length; ++i) {
            // 手动去重
            if(i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }

            hasVisited[i] = true;
            subsetList.add(nums[i]);
            backTracking(i + 1, size, hasVisited, subsetList, subsetsWithDups, nums);
            subsetList.remove(subsetList.size() - 1);
            hasVisited[i] = false;
        }
    }

}
