package part_1.easy.arrayandmatrix;

public class replaceSpace_swordOffer05 {

    public String replaceSpace(String s) {
        /**
         * 分析题意：
         * ① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成
         * 三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。
         * ② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，
         * 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填
         * 充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原
         * 来字符串的内容。
         * ③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
         */
        StringBuilder str = new StringBuilder(s);
        int P1 = str.length() - 1;
        for(int i = 0; i <= P1; ++i) {
            if(str.charAt(i) == ' ') {
                str.append("  "); // 填充两个空格
            }
        }
        int P2 = str.length() - 1;
        while(P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if(c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

}
