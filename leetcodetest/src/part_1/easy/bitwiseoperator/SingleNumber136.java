package part_1.easy.bitwiseoperator;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        /*
         * 分析题意：正常的每个数都出现两次，成对这个特点，在位运算里面可以用到异或，相同的两个数异或为0，而0异或任何数
         * 都等于任何数，这样我们遍历一边nums，把所有元素都异或连接起来，成对的都抵消为0了，最后就剩 n 个0和那单独的一
         * 个元素异或就等于那个元素。
         */

        // 初始化answer为0，因为0异或任何数都等于任何数所以不影响后面连续的元素异或。
        int answer = 0;
        for(int num : nums) answer ^= num;
        return answer;
    }

}
