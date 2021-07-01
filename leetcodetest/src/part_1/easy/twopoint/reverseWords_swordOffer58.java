package part_1.easy.twopoint;

public class reverseWords_swordOffer58 {

    public String reverseWords(String s) {
        /**
         * 分析题意：我们可以先翻转每个单词，再翻转整个字符串。这样就把单词成功全部翻转过来了，但是对于中间和两边有空格的情况
         * 我们任然需要开辟额外的空间来拼接处理多余的空格。最后才能返回结果。
         */
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while(j <= n) {
            if(j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);

        // 处理多余的空格
        String s_ret = new String(chars).trim();
        String[] strings = s_ret.split("[\\s]+"); // “\s”的意思是匹配任意空白符，“\s+” 匹配任意一个或多个任意空白符
        StringBuilder sb  = new StringBuilder();
        for(String sc : strings) {
            sb.append(sc).append(" ");
        }
        return sb.toString().trim();
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            swap(chars, start++, end--);
        }
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

}
