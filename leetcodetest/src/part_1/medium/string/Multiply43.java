package part_1.medium.string;

public class Multiply43 {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; --i) {
            int n1 = num1.charAt(i) - '0';
            for(int j = n - 1; j >=0; --j) {
                int n2 = num2.charAt(j) - '0';
                // 根据乘法竖式的规律，按位进行相乘
                int sum = (res[i + j + 1] + n1 * n2);
                // 两数相乘后的结果中这一位上需要更新的值
                res[i + j + 1] = sum % 10;
                // 把前一位的进位加上
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; ++i) {
            if(i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
