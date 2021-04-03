package part_1.easy.math;

public class GCDandLCM_multiple {
    /**
     * 最大公约数和最小公倍数的多种解法
     */

    public static void main(String[] args) {
        int a = 18, b = 12;
        GCDandLCM_multiple gcDandLCM_multiple = new GCDandLCM_multiple();
        System.out.println("============================== 最大公约数 ==============================");
        System.out.println("方法一 暴力穷举法   关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_enumeration(a, b));
        System.out.println("方法二 写法一 辗转相除法的递归写法   关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_division_recursive(a, b));
        System.out.println("方法二 写法二 辗转相除法的迭代写法   关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_division_iteration(a, b));
        System.out.println("方法三 写法一 辗转相减法（尼考曼彻斯法）  关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_substract_recursive(a, b));
        System.out.println("方法三 写法二 辗转相减法（尼考曼彻斯法）  关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_substract_iteration(a, b));
        System.out.println("方法四  使用位操作和减法   关于 a = "+ a +", b = "+ b +"的最大公约数为：" + gcDandLCM_multiple.gcd_shift_substract(a, b));
        System.out.println("============================== 最小公倍数 ==============================");
        System.out.println("关于 a = "+ a +", b = "+ b +"的最小公倍数为：" + gcDandLCM_multiple.lcm(a, b));
    }

    // 首先时求最大公约数（最大公因数）

    // 方法一 暴力穷举法求两个数的最大公约数
    private int gcd_enumeration(int a, int b) {
        // 比较a和b，找到a，b中较小的那个数，减少for循环次数，
        // 因为最大公约数是一定不大于a，b中更小的那个的(整数拆分后只能是更小的整数)
        int smaller = a;
        if(b < a) {
            smaller = b;
        }

        int gcd = 1;
        for(int i = 2; i <= smaller; ++i) {
            if(a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // 方法二 写法一 辗转相除法的递归写法
    private int gcd_division_recursive(int a, int b) {
        return b == 0 ? a : gcd_division_recursive(b, a % b);
    }

    // 方法二 写法二 辗转相除法的迭代写法
    private int gcd_division_iteration(int a, int b) {
        // 判断条件之所以是b，是因为我们这里用b来接收a % b 的结果，即上一步算法下来的余数
        // 余数为零时，我们就找到了结果
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 方法三 辗转相减法（尼考曼彻斯法）
    // 算法步骤：
    // 若a > b，则a = a - b
    // 若b > a，则b = b - a
    // 若a == b，则a(或b)即为最大公约数
    // 若a != b，则回到1

    // 例子
    // 求32,12的最大公约数：
    //   32 - 12 = 20 (20 > 12)
    //   20 - 12 = 8 (8 < 12)
    //   12 - 8 = 4 (4 < 8)
    //   8 - 4 = 4 (4 == 4)
    // 所以最大公约数是4

    // 方法三 辗转相减法（尼考曼彻斯法）递归写法
    private int gcd_substract_recursive(int a, int b) {
        if(a == b) {
            return a;
        } else if(a > b) {
            return gcd_substract_recursive(a - b, b);
        } else {
            return gcd_substract_recursive(a, b - a);
        }
    }

    // 方法三 辗转相减法（尼考曼彻斯法）迭代写法
    private int gcd_substract_iteration(int a, int b) {
        // 如果a,b不相等，则用大的数减去小的数，直到相等为止
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // 方法四  使用位操作和减法求解最大公约数

    // 首先对于位运算，我们是对我们常用十进制数转为二进制数之后做的位置移动的运算
    // 运算符叫双目移动运算符（左移 << ，右移 >>）
    // 所以对于乘 2 和除 2 操作我们都可以转换为移位操作

    // 本方法算法思路
    // 对于 a 和 b 的最大公约数 f(a, b)，有：
    //
    // 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
    // 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
    // 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
    // 如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);

    private int gcd_shift_substract(int a, int b) {
        // 还是首先要保证传进来的两个参数中，第一个参数a要比b大，否则交换位置
        if(a < b) {
            return gcd_shift_substract(b, a);
        }
        if(b == 0) {
            return a;
        }
        if(isEven(a) && isEven(b)) {
            return 2 * gcd_shift_substract(a >> 1, b >> 1);
        } else if(isEven(a) && !isEven(b)) {
            return gcd_shift_substract(a >> 1, b);
        } else if(!isEven(a) && isEven(b)) {
            return gcd_shift_substract(a, b >> 1);
        } else  {
            return gcd_shift_substract(b, a - b);
        }
    }

    // 是否为偶数判断
    private boolean isEven(int x) {
        if(x % 2 == 0) {
            return true;
        }
        return false;
    }

    // 顺带记住一个公式求最小公倍数，方法不做展开

    // 算法思路
    // 两个数的最小公倍数 等于 两数之积除以他们的最大公约数
    // lcm(a, b) = (a * b) / lcd(a, b)
    private int lcm(int a, int b) {
        return (a * b) / gcd_shift_substract(a, b);
    }
}
