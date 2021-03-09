package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {


    public static void main(String[] args) {
        int n = 4, k = 2;
        Combine77 combine77 = new Combine77();
        System.out.println(combine77.combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backTracking(1, k, n, combineList, combinations);
        return combinations;
    }

    private void backTracking(int start, int k, int n, List<Integer> combineList, List<List<Integer>> combinations) {
        if(k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }

        for(int i = start; i <= n - k + 1; ++i) {
            combineList.add(i);
            backTracking(i + 1, k - 1, n, combineList, combinations);
            combineList.remove(combineList.size() - 1);
        }
    }

}
