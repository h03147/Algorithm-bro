package part_1.easy.string;


public class reverseRightWords149 {

    public static void main(String[] args) {
        /**
         * 编程之美2.17（204页）数组循环位移改编成字符串循环位移，
         * 给一个字符串s，位移位数k，让你把字符串向右循环位移k位后
         * 输出结果
         */
        String s = "abcd123";
        int k = 3;

        // 方法一 字符串切片
//        s = s.substring(s.length() - k, s.length()) + s.substring(0, s.length() - k);
//        System.out.println("方法一：" + s);

        // 方法二 列表遍历拼接
//        StringBuilder sb = new StringBuilder();
//        for(int i = s.length() - k; i < s.length(); ++i) {
//            sb.append(s.charAt(i));
//        }
//        for(int j = 0; j < s.length() - k; ++j) {
//            sb.append(s.charAt(j));
//        }
//        s = sb.toString();
//        System.out.println("方法二：" + s);

        // 方法二优化版 列表遍历拼接
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - k; i < s.length() + s.length() - k; ++i) {
            sb.append(s.charAt(i % s.length()));
        }
        s = sb.toString();
        System.out.println("方法二优化版：" + s);
    }


}
