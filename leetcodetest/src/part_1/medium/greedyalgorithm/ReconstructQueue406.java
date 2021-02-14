package part_1.medium.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue406 {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> array2list = new ArrayList<>();
        for(int[] p : reconstructQueue(people)) {
            for(int i : p) {
                list1.add(i);
            }
        }
        array2list.add(list1);
        System.out.println(array2list);
    }

    public static int[][] reconstructQueue(int[][] people) {
        /*
         * 分析题意：身高较高的同学先插入操作，然后身高矮的同学按照k为索引位置插入k位置上，
         * 他前面肯定右k个高个子。
         * 排序规则，先按身高h降序排序，再按比高个数k升序排序
         * 等遍历排序一遍后，还有人没有落位，我们再按照他的k值
         * 做为索引将其插入到k位置上。
         */
        // 看一下插入排序过程
        // 先排序一遍
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 在按照k一个一个插入
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]

        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> array2list = new ArrayList<>();
        for(int[] p : people) {
            array2list.add(p[1], p);
        }

        return array2list.toArray(new int[array2list.size()][2]);
    }
}
