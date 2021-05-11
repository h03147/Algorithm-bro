package part_1.easy.string;

public class IsContainsByPointer148 {
    /**
     * 题目来自《编程之美》第221页，字符串循环移位包含（leetcode刷题挑战148题）
     * 给定两个字符串s1和s2，要求判定s2是否能通过被s1作循环位移判断得到的字符串包含，
     * 例如给定s1 = AABCD 和 s2 = CDAA，返回true；给定s1 = ABCD和s2 = ACBD，
     * 返回false。
     */

    public static void main(String[] args) {
        String s1 = "AABCD";
        String s2 = "CDAA";
//        String s2 = "ACBD";
        System.out.println(isContainsByPointer(s1, s2));
    }

    private static boolean isContainsByPointer(String s1, String s2) {
        // 边界值判断
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) return false;
        // 方法一 调用String类自带的方法
//        s1 = s1.concat(s1);
//        return s1.contains(s2);

        // 方法二 自己实现contains算法，双指针循环查找

        int s1Len = s1.length();
        int s2Len = s2.length();

        for(int i = 0; i < s1Len * 2; ++i) {
            // 可能匹配的起始位置判断
            if(s1.charAt(i % s1Len) == s2.charAt(0)) {
                for(int j = 0; j < s2Len; ++j) {
                    // 如果指针j在s2串中能匹配到最后一个字符，返回true
                    if(j == (s2Len - 1)) {
                        return true;
                    } else if(s1.charAt((i + j) % s1Len) != s2.charAt(j)) {
                        // s1和s2中对应字符遍历匹配时，中间任意一个字符不匹配就证明暂时不匹配，结束内层循环s1继续向后查找
                        break;
                    }
                }
            }
        }
        // s1两趟循环完毕后还未匹配则说明不存在
        return false;
    }
}
