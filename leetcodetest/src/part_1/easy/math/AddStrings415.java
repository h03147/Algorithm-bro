package part_1.easy.math;

public class AddStrings415 {

    public static void main(String[] args) {
        System.out.println(new AddStrings415().addStrings("101", "50"));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(carry == 1 || i >= 0 || j >= 0) {
            // 只要没越界，就取每一位字符将其转换成整型再做加法运算
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            // 10进制数以然可以用辗转相除法求结果
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

}
