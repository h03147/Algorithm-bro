package part_1.hard.ufs;

/**
 * description: 839. 相似字符串组
 */
public class numSimilarGroups839 {
    private static int[] parent839;

    public static void main(String[] args) {
        String[] strs = {"tars", "rats", "arts", "star"};
        System.out.println(numSimilarGroups(strs));
    }

    public static int find839(int x) {
        return parent839[x] == x ? x : (parent839[x] = find839(parent839[x]));
    }

    public static void union839(int x, int y) {
        parent839[find839(x)] = find839(y);
    }

    public static int numSimilarGroups(String[] strs) {
        /*
         * 题意分析，判断两个str是不是同一个相似组，要么完全相同，要么只交换一次其中一个
         * 字符串中两个位置的字符后可与另一个字符串相等，则判断为相似，另外，根据题意相似
         * 组内大于两个字符串有传递性，这就是连通性问题，
         * 例如 字符串a与字符串b相似，字符串a不能与字符串c直接相似，但是字符串b与字符串c
         * 相似，根据连通传递性规则，字符串a和字符串c也相似，最后要输出有多少个这样的相似
         * 组，实际上就是再问连通分量的个数。
         */
        int n = strs.length;
        int m = strs[0].length();
        parent839 = new int[n];
        for(int i = 0; i < n; ++i) {
            parent839[i] = i;
        }
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int newX = find839(i), newY = find839(j);
                if(newX == newY) {
                    continue;
                }
                if(check839(strs[i], strs[j], m)) {
                    parent839[newX] = newY;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; ++i) {
            if(parent839[i] == i) {
                answer++;
            }
        }
        return answer;
    }

    // 比较两个字符串，超过两个对应位置不匹配，则不是相似组
    public static boolean check839(String a, String b, int length) {
        int num = 0;
        for(int i = 0; i < length; ++i) {
            if(a.charAt(i) != b.charAt(i)) {
                num++;
                if(num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
