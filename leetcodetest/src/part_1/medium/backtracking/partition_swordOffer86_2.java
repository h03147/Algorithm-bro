package part_1.medium.backtracking;

public class partition_swordOffer86_2 {
    public String[][] partition(String s) {
        // 排列组合问题，优先考虑用回溯的思路，然后加双指针回文串判断的模板
        List<String> tempPartition = new ArrayList<>();
        List<List<String>> partitions = new ArrayList<>();
        backTracking(s, tempPartition, partitions);

        // String[][]返回类型真恶心
        String[][] res = new String[partitions.size()][];
        int outIdx = 0;
        for(List<String> tempRes : partitions) {
            String[] one = new String[tempRes.size()];
            int innerIdx = 0;
            for(String str : tempRes) {
                one[innerIdx++] = str;
            }
            res[outIdx++] = one;
        }
        return res;
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

    // 回文串的标准判断模板
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
