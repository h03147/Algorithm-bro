package part_1.medium.string;

public class MyAtoi8 {

    int sign = 1;
    int ans = 0, pop = 0;
    boolean hasSign = false; // 代表是否开始转换数字，用来过滤掉非数字
        for(int i = 0; i < str.length(); ++i) {
        // 先判断正负号
        if(str.charAt(i) == '-' && !hasSign) {
            sign = -1;
            hasSign = true;
            continue;
        }
        if(str.charAt(i) == '+' && !hasSign) {
            sign = 1;
            hasSign = true;
            continue;
        }
        // 过滤空格
        if(str.charAt(i) == ' ' && !hasSign) {
            continue;
        }

        // 合法的数字做数字转换
        if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            hasSign = true;
            pop = str.charAt(i) - '0';
            // 判断有符号整型边界溢出问题
            if(ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7)) {
                return 2147483647;
            }
            if(ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8)) {
                return -2147483648;
            }
            ans = ans * 10 + pop;
        } else {
            return ans * sign;
        }
    }
        return ans * sign;
}

}
