package part_1.easy.greedyalgorithm;

import java.util.Arrays;

public class FindContentChildren455 {

    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren(g, s));

    }

    public static int findContentChildren(int[] g, int[] s) {
        // 孩子没有胃口或者没有饼干时，结束返回0
        if(g == null || s == null) {
            return 0;
        }

        // 都不为空时，g和s都先排序，以保证更快的找
        // 到刚好匹配胃口值g[i]的饼干大小s[j]
        Arrays.sort(g);
        Arrays.sort(s);
        int g_count = 0, s_count = 0;
        while(g_count < g.length && s_count < s.length) {
            if(g[g_count] <= s[s_count]) {
                g_count++;
            }
            s_count++;
        }
        return g_count;
    }
}
