package part_1.medium.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public static List<Integer> partitionLabels(String S) {
        /*
         * 分析题意：我们要找的切片片段中的字符串都是互不相交的，
         * 比如第一个片段里面有多有a，那么字符串中最后一次出现a
         * 的位置必须也在第一片段中，不可能出现在后面的片段中，此
         * 片段才有效，这题有点像之前做过的不重叠子区间的升级版，
         * 你需要先找到S串中每个字母最后一次出现的下标位置，并把
         * 它一一存储下来，后面再找到划分后尽可能多的最大不相交子区
         * 间，然后返回每个区间的长度即可。
         */

        // 开辟一个26个空间大小的数组作为字典，存储S串中可能出现的所有字符串最后一次出现的位置下标
        int[] lastVisitedIndex = new int[26];
        int len = S.length();
        for(int i = 0; i < len; ++i) {
            lastVisitedIndex[S.charAt(i) - 'a'] = i;
        }

        // 初始化每个片段开始下标的start，结束下标的end，对于每个访问到的字母 S(i)，得到当前字母的
        // 最后一次出现的下标位置end(i), 则当前有多个字母片段的最后结束下标一定不小于end(i)才能满足
        // 字母在这个区间内被隔离成功，在其他区间不出现。因此我们调用Math.max(end, end(i))进行比较
        // ，就能保证每次划分的最大子区间是局部最优解了。
        // 这里主要是结合双指针和贪心算法来求解的

        // 为结果集开辟空间
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0; // 初始化首尾指针位置在起点
        for(int j = 0; j < len; ++j) {
            end = Math.max(end, lastVisitedIndex[S.charAt(j) - 'a']);
            if(j == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }
}
