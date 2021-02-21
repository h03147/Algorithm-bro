package part_1.medium.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute241 {

    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(diffWaysToCompute(input));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        // 返回结果集开辟空间
        List<Integer> ways = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; ++i) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                // 递归把运算拆分到最小
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        // 如果为空的情况，说明没有运算符
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
