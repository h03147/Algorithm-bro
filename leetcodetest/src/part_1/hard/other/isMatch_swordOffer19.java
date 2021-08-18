package part_1.hard.other;

public class isMatch_swordOffer19 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //p中的第j个位置为'*';
                if (p.charAt(j - 1) == '*') {	// 不考虑p中第j-1个元素，因为第j个元素为'*'。匹配0次的情况下前一个元素是什么无所谓。就看p中前j-2个元素和s中前i个元素的匹配情况
                    f[i][j] = f[i][j - 2]; // 当p中第j个元素为'*'是前面必有符号所以可以为j-2。
                    // 查看s中的前i个位置，和p中前j-1个位置的匹配情况，如果匹配
                    if (matches(s, p, i, j - 1)) {
                        // 这里的f[i-1][j],表示s中前i-1个元素和p中前j个元素的匹配情况。
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    // s中第i个元素和p中第j个元素的匹配情况
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // 如果p中第j个元素为'.'
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        // 返回s中第i个元素和p中第j个元素的匹配情况
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
