package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {


    public static void main(String[] args) {
        String s = "aab";
        Partition131 partition131 = new Partition131();
        System.out.println(partition131.partition(s));
    }

    public List<List<String>> partition(String s) {
        /*
         * 分析题意：本题依然是排列组合的问题，我们依然考虑用回溯的算法来解题，不同于
         * 之前我们所写的回溯题目类型都是数值,这里改成了String类型的比较，并且结合了
         * 前面双指针判断回文字符串的知识来一同解题。
         */
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        backTracking(s, tempPartition, partitions);
        return partitions;
    }

    private void backTracking(String s, List<String> tempPartition, List<List<String>> partitions) {
        if(s.length() == 0) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }

        for(int i = 0; i < s.length(); ++i) {
            if(isPalindrome(s, 0, i)) {
                tempPartition.add(s.substring(0, i + 1));
                backTracking(s.substring(i + 1), tempPartition, partitions);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    // 判断回文字符串
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
