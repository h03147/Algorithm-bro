package part_1.easy.string;

public class IsIsomorphic205 {

    public boolean isIsomorphic(String s, String t) {
        /*
         * 分析题意：题目要求找到所有对应位置的映射关系都要一一对应，不能一对多或者多对一，故我们只需要同步遍历
         * 两个字符串对应位置字符，给他们打上唯一的关联标识，并且标识还不能重复，才能保证唯一性。故我们可以用类
         * 似于时间戳的增量下标i作为标识，保证了串行序列化，本题就可以求解了。需要注意的是之前出现过的对应关联的
         * 两个对应字符，如果在后面遍历时再一次出现时，在比较完他们上一次关联时对应标识相同的情况下，我们要再一次
         * 更新其标识为这次遍历时的当前位置，保证永远都是和上次出现的位置标识递进的更新。
         * 我们可以用两个数组同步遍历其相对同步位置上的字符ASCII码作为索引下标，判断对应的值上他们两上一次出现
         * 时的位置下标（此下标是从两字符串起始位置0开始同步向后遍历的下标，而非上面说的两个数组的下标）是否相同，
         * 这里我们用for循环的不重复增量次数i（时间戳）作为下标，如果匹配成功则更新其下标为本次最新关联位置的下标。
         * 即可满足题意。
         */
        int[] preIndexOfS = new int[128];
        int[] preIndexOfT = new int[128];

        for(int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }

}
