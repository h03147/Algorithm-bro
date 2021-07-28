package part_1.medium.dfs;

public class permutation_swordOffer38 {

    private List<String> ret_list = new ArrayList<>();

    public String[] permutation(String s) {
        if(s.length() == 0) return new String[0];
        char[] s2c = s.toCharArray();
        Arrays.sort(s2c);
        backtracking(s2c, new boolean[s2c.length], new StringBuilder());
        String[] ret = new String[ret_list.size()];
        for(int i = 0; i < ret_list.size(); ++i) {
            ret[i] = ret_list.get(i);
        }
        return ret;
    }

    private void backtracking(char[] s2c, boolean[] visited, StringBuilder sb) {
        if(sb.length() == s2c.length) {
            ret_list.add(sb.toString());
            return;
        }
        for(int i = 0; i < s2c.length; ++i) {
            if(visited[i]) {
                continue;
            }
            // 去掉连续重复的字符
            if(i != 0 && s2c[i] == s2c[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            sb.append(s2c[i]);
            backtracking(s2c, visited, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

}
