package part_1.easy.math;

public class AddBinary67 {

    public static void main(String[] args) {
        System.out.println(new AddBinary67().addBinary("101", "100"));
    }

    public String addBinary(String a, String b) {
        // 根据加法运算法则，我们需要从后先前遍历相加，注意起始下标位置
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        // 如果a，b各个位置上两数和加起来不为零或者i，j没有遍历到起始位置
        while(carry == 1 || i >= 0 || j >= 0) {
            // 只要为1就是有效相加位，记录下来
            if(i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if(j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            // 辗转相除法取余数反向输出即为结果
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

}
