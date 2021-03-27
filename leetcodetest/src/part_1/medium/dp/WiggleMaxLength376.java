package part_1.medium.dp;

public class WiggleMaxLength376 {

    public static void main(String[] args) {
        System.out.println(new WiggleMaxLength376().wiggleMaxLength(new int[] {1, 7, 4, 9, 2, 5}));
    }

    public int wiggleMaxLength(int[] nums) {
        /*
         * 分析题意：摆动序列，光看名字就很有规律，并且可以找到转移模板，就好比股票一样
         * 有涨有跌震荡波动才是人生常态，就好比呼吸一样，你不能只呼不吸或者只吸不呼对吧
         * 如果连续涨和连续跌都会吓死人的。故这题，满足下一个数比上一个数大，那么下下个
         * 满足条件的数必须是比下一个数小才能算进来，否则摆动子序列长度永远不增加。
         */
        int up = 1, down = 1;
        for(int i = 1; i < nums.length; ++i) {
            // 只要碰不到下一个下跌(nums[i] < nums[i - 1]), up 的数值大小将永远原地踏步， else if 同理
            if(nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if(nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
