package part_1.easy.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * description: 888. 公平的糖果棒交换 数学方程式思维 + 知识点HashSet
 *
 */
public class FairCandySwap888 {

    public static void main(String[] args) {
        int[] A = {1, 1}, B = {2, 2};
        int[] array_answer = fairCandySwap(A, B);
        ArrayList<Integer> list_answer = new ArrayList<Integer>(array_answer.length);
        for(int item : array_answer) {
            list_answer.add(item);
        }
        System.out.println(list_answer);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        /**
         * 本题如果直接暴力求解会时间复杂度会超时，所以需要一些优化
         * 这里用到了数学的方程设未知数的思想来求解，因为最后要输出
         * 两个未知数，且第一个未知数属于爱丽丝，第二个未知数属于鲍
         * 勃，所以隐含了未知数x和未知数y之间的某种关系需要找到。
         * 设：爱丽丝的糖果总数为sumA，鲍勃的糖果总数为sumB，爱丽丝
         * 拿糖果x和鲍勃换糖果y正好使两人的糖果总数满足了sumA = sumB
         * 于是就有 sumA - x + y = sumB - y + x
         * 移项后 x = (sumA -sumB) / 2 + y, 故根据这个关系我们遍历
         * B中每一个y',然后根据上述关系式带入得到一个x'，再去A中找是否
         * 存在这个x', 存在则为我们要交换的两个值x和y。
         **/

        // 继续考虑，此时时间复杂度降到了线性的时间复杂度O(n + m)
        // 空间复杂度O(n), 这是我们要找到一个容器存数组A，方便快速
        // 查找，查找快我们想到了HashMap，但是考虑到重复的数，选一个
        // 交换即可，可以节省空间于是想到了set集合的形式存储即可

        int sumA = 0, sumB = 0;
        for(int itemA : A) {
            sumA += itemA;
        }

        for(int itemB : B) {
            sumB += itemB;
        }

        int delta = (sumA - sumB) / 2;
        HashSet<Integer> hashSetA = new HashSet<Integer>();

        for(int numX : A) {
            hashSetA.add(numX);
        }

        int[] answer = new int[2];
        for(int numY : B) {
            int newX = delta + numY;
            if(hashSetA.contains(newX)) {
                answer[0] = newX;
                answer[1] = numY;
                // 找到了立马输出
                break;
            }
        }
        return answer;
    }


}
