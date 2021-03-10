package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {

    public static void main(String[] args) {
        CombinationSum2_40 combinationSum2_40 = new CombinationSum2_40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2_40.combinationSum2(candidates, target));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        boolean[] hasVisited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(0, hasVisited, combineList, combinations, candidates, target);
        return combinations;
    }

    private void backTracking(int start, boolean[] hasVisited, List<Integer> combineList, List<List<Integer>> combinations, int[] candidates, int target) {
        if(target == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }

        for(int i = start; i < candidates.length; ++i) {
            if(i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if(candidates[i] <= target) {
                hasVisited[i] = true;
                combineList.add(candidates[i]);
                backTracking(i + 1, hasVisited, combineList, combinations, candidates, target - candidates[i]);
                combineList.remove(combineList.size() - 1);
                hasVisited[i] = false;
            }
        }
    }

}
