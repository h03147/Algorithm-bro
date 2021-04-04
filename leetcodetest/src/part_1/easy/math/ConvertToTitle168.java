package part_1.easy.math;

public class ConvertToTitle168 {

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle168().convertToTitle(10));
    }

    public String convertToTitle(int columnNumber) {
        // // 递归的写法
        // if(columnNumber == 0) {
        //     return "";
        // }
        // // 这里做自减操作时因为我们拿的时现实生活中的 1-26 表示 A-Z 二十六个字母
        // // 而后面拼接的时候计算机不这么认为计算机认为你从 'A'开始拼接，当前下标时
        // // 从0开始的也就是 0-25 表示 A-Z，所以每一位数做26进制转换的时候，每次我们都
        // // 时错开了一位，那减回来就好了(由此可见计算机对0有执念啊，太爱0了)
        // columnNumber--;
        // return convertToTitle(columnNumber / 26) + (char) (columnNumber % 26 + 'A');

        // 迭代写法
        if(columnNumber == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

}
