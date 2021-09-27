package part_1.easy.string;

public class StrStr28 {

    public int strStr(String haystack, String needle) {
        // // 方法一 调包侠 真香
        // return haystack.indexOf(needle);
        // 双指针暴力匹配
        int m = haystack.length(), n = needle.length();
        if(needle == null || n == 0) return 0;
        int a = 0;
        for(int i = 0; i <= m - n; ++i) {
            a = i;
            int b = 0;
            while(b < n && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if(b == n) {
                return i;
            }
        }
        return -1;
    }

}
