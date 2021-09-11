package part_1.easy.math;

public class Reverse7 {

    public int reverse(int x) {
        // // 方法一 转字符串后反向拼接
        // String x2s = String.valueOf(x);
        // char one = x2s.charAt(0);
        // boolean isNegative = false;
        // if(one == '-') {
        //     isNegative = true;
        //     x2s = x2s.substring(1);
        // }
        // StringBuilder sb = new StringBuilder();
        // for(int i = x2s.length() - 1; i >= 0; --i) {
        //     sb.append(x2s.charAt(i));
        // }
        // try {
        //     x = isNegative ? Integer.parseInt("-" + sb.toString()) : Integer.parseInt(sb.toString());
        //     return x;
        // } catch (Exception e) {
        //     return 0;
        // }

        // 方法二 数学方法 辗转相除法倒置即可
        int reverseNum = 0;
        while(x != 0) {
            if(reverseNum > Integer.MAX_VALUE / 10 || reverseNum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum;
        // return reverseNum > Integer.MAX_VALUE / 10 || reverseNum < Integer.MIN_VALUE / 10 ? 0 : reverseNum;

    }

}
