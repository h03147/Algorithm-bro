package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {
        CombinationSum39 combinationSum39 = new CombinationSum39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum39.combinationSum(candidates, target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backTracking(0, combineList, combinations, candidates, target);
        return combinations;
    }

    private void backTracking(int start, List<Integer> combineList, List<List<Integer>> combinations, int[] candidates, int target) {
        if(target == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }

        for(int i = start; i < candidates.length; ++i) {
            if(candidates[i] <= target) {
                combineList.add(candidates[i]);
                backTracking(i, combineList, combinations, candidates, target - candidates[i]);
                combineList.remove(combineList.size() - 1);
            }
        }
    }

}
