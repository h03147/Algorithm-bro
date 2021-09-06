package part_1.medium.string;

public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        // 这题解题思路用到滑动窗口的思路
        // 从第一个字符开始创建一个候选的最长字串的窗口，然后尝试向右不
        // 断滑动窗口找到更长的串
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rt = -1, ans = 0;
        for(int i = 0; i < n; ++i) {
            // 窗口左边界向右移动一步，移除一个字符，尝试找到新的更长的
            // 不重复子串
            if(i != 0) {
                set.remove(s.charAt(i - 1));
            }

            // 不断延长窗口右边界，尝试找到更长的不重复子串区间
            while(rt + 1 < n && !set.contains(s.charAt(rt + 1))) {
                set.add(s.charAt(rt + 1));
                rt++;
            }
            ans = Math.max(ans, rt - i + 1);
        }
        return ans;
    }

}
