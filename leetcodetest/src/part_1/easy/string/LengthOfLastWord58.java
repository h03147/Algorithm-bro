package part_1.easy.string;

public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        // // 方法一 标记清楚空格法
        // boolean lastOne = false;
        // int cnt = 0;
        // for(int i = s.length() - 1; i >= 0; --i) {
        //     if(s.charAt(i) == ' ' && !lastOne) {
        //         continue;
        //     }
        //     if(lastOne && s.charAt(i) == ' ') {
        //         break;
        //     }
        //     lastOne = true;
        //     cnt++;
        // }
        // return cnt;

        // 方法二 使用trim()去掉首尾空格直接反向遍历到第一个中间的空格结束
        s = s.trim();
        int cnt = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) == ' ') {
                break;
            }
            cnt++;
        }
        return cnt;
    }

}
