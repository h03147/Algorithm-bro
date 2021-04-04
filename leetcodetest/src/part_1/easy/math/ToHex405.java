package part_1.easy.math;

public class ToHex405 {

    public static void main(String[] args) {
        System.out.println(new ToHex405().toHex(10));
    }

    public String toHex(int num) {
        char[] dictionary = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if(num == 0) {
            return "0";
        }
        StringBuilder sb =new StringBuilder();
        while(num != 0) {
            // 这里与运算操作是在取二进制数每四位一保留对应十六进制表中的哪一个数
            // 二进制数每四位表示一位十六进制数2^4 = 2 * 2 * 2 * 2 = 16
            // 0b代表二进制数的意思，如果不好理解，这里 num & 0b1111 可以换成
            // num & 15 或者 num & 0xf
            // 都是一个意思代表十六进制字典表中的第十六个数f
            sb.append(dictionary[num & 0b1111]);
            // 这里做逻辑右移4位和上一题除以7同理，我们知道二进制数中每右移一位代
            // 表除2，那右移四位就是代表除16，循环的中间存储过程，辗转相除法的每一
            // 趟的结果
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

}
