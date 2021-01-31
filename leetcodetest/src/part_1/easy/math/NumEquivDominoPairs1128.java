package part_1.easy.math;


/**
 * description: 1128. 等价多米诺骨牌对的数量 二元数组，正反相等
 */
public class NumEquivDominoPairs1128 {

    public static void main(String[] args) {
        int[][] dominoes ={{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        // 既然是二元组，不妨把两个数拼成一个数做降维操作
        // 本题的核心思想需要比较和交换，让二元组中第一个数始终小于第二个数，
        // 然后让第一个数当十位，第二个数当个位，这样组成的一个两位数当作计数数组的下标即可
        // [a, b] => if (a < b) {a * 10 + b} else {b * 10 + a}
        int[] copy = new int[100];
        int answer = 0;
        for(int[] arr : dominoes) {
            answer += arr[0] < arr[1] ? copy[arr[0] * 10 + arr[1]]++ : copy[arr[1] * 10 + arr[0]]++;
        }
        return answer;
    }
}
