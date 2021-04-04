package part_1.easy.math;

public class ConvertToBase7_504 {

    public static void main(String[] args) {
        System.out.println(new ConvertToBase7_504().convertToBase7(10));
    }

    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        // 不断地运算，进行字符串的拼接，这里用到StringBuilder
        StringBuilder sb = new StringBuilder();
        // 如果是负数我们也先转换成正数方便计算，最后结果记得符号加回来就行
        boolean isNegative = num < 0;
        if(isNegative) {
            num = - num;
        }

        // 辗转相除法让十进制数转换成七进制
        while(num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        // 最后结果就是所有的余数反过来写
        String answer = sb.reverse().toString();
        return isNegative ? "-" + answer : answer;
    }

}
