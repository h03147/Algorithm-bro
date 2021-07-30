package part_1.medium.sort;

public class minNumber_swordOffer45 {

    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] nums2str = new String[n];
        for(int i = 0; i < n; ++i) {
            nums2str[i] = nums[i] + "";
        }
        // 比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
        Arrays.sort(nums2str, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        System.out.println(Arrays.toString(nums2str));
        String ret = "";
        for(String str : nums2str) {
            ret += str;
        }
        return ret;
    }

}
