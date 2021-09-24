package part_1.medium.string;

public class GenerateParenthesis22 {

    public List<String> generateParenthesis(int n) {
        // 分析题意：深度优先遍历去匹配左右括号
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }


    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在左边和右边剩余的括号数都等于 0 的时候结算
        if(left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if(left > right) {
            return;
        }

        if(left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if(right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

}
