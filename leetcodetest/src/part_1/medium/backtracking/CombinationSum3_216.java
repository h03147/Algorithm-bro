package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {


    public static void main(String[] args) {
        CombinationSum3_216 combinationSum3_216 = new CombinationSum3_216();
        int k = 3, n = 7;
        System.out.println(combinationSum3_216.combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backTracking(1, k, n, combineList, combinations);
        return combinations;
    }

    private void backTracking(int start, int k, int n, List<Integer> combineList, List<List<Integer>> combinations) {
        if(k == 0 && n == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }

        // 不满足的情况 k先减到0，但是n没有等于0
        if(k == 0 || n == 0) {
            return;
        }

        for(int i = start; i <= 9; ++i) {
            combineList.add(i);
            backTracking(i + 1, k - 1, n - i, combineList, combinations);
            combineList.remove(combineList.size() - 1);
        }
    }

}
