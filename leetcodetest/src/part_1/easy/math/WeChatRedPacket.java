package part_1.easy.math;

import java.util.Random;
import java.util.Scanner;

public class WeChatRedPacket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请您输入总金额:");
        double sum = sc.nextDouble();
        System.out.print("请输入红包个数:");
        int people = sc.nextInt();
        System.out.println();
        robRed(sum, people);
    }

    private static void robRed(double sum, int num) {
        double min = 0.01;         // 最少抢到0.01
        Random rd = new Random();  // 定义随机数
        for (int i = 1; i < num; i++) {
            double max = Math.ceil(sum - min * (num - i)); //第 i 个人可以拿到的最大钱数 Math.ceil()向上取整
            double get = rd.nextInt((int) ((max - min) * 100)) / 100;
            // get 有可能是0，所以限制最小值为0.01
            double money = get + min;
            sum -= money;
            System.out.print("第 " + i + " 个人抢到 " + String.format("%.2f", money) + "元" + ", ");
            if (i % 8 == 0) {
                System.out.println();
            }
        }
        System.out.print("第 " + num + " 个人抢到 " + String.format("%.2f", sum) + "元");
    }

}
