package part_1.medium.string;

public class Convert6 {

    public String convert(String s, int numRows) {

        /*
         * 分析题意：通过从左向右迭代字符串s，我们可以轻松地确定字符s位于 Z 字形图案中的哪一行
         * ，我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行共有多少行。
         * 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适
         * 的行进行跟踪。
         * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
         * 可以理解为从右到左 之字形 玩俄罗斯方块，每次方块都从右边边缘出现，一直落到左边的边缘。
         */

        if(numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); ++i) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }

}
