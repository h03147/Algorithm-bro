package part_1.hard.dp;

public class MaxProfit123 {

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(new MaxProfit123().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /*
         * 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
         * 未进行过任何操作；
         * 只进行过一次买操作；
         * 进行了一次买操作和一次卖操作，即完成了一笔交易；
         * 在完成了一笔交易的前提下，进行了第二次买操作；
         * 完成了全部两笔交易。
         */

        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for(int curPrice : prices) {
            if(firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }

            if(firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }

            if(secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }

            if(secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }

}
