package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        // 所有可能的ip地址组合
        List<String> addresses = new ArrayList<>();
        // 每一个可能的ip地址
        StringBuilder tempAddress = new StringBuilder();
        // 进行回溯算法，拼凑出所有可能的结果
        backTracking(0, tempAddress, addresses, s);
        return addresses;
    }

    private static void backTracking(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        // 如果s长度为0或者指针k到达结尾位置有合法的4段数字的ip地址，就进一步判断s本来就是空的情况还是说是
        // 因为遍历到结尾后s被截取光了，前者则结束本次回溯算法，后者则说明找到了一个满足条件的ip地址添加到
        // 结果集再结束本次回溯
        if(s.length() == 0 || k == 4) {
            if(s.length() == 0 && k == 4) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        // 遍历所有可能的组合情况
        for(int i = 0; i < s.length() && i <= 2; ++i) {
            // 如果当前s串第一个字符就是0，根据数字前置非0原则那ip地址的这一段只能0，直接结束本次dfs
            if(i != 0 && s.charAt(0) == '0') {
                break;
            }
            // 找到一个片段就进一步判断其合法性
            String part = s.substring(0, i + 1);
            if(Integer.valueOf(part) <= 255) {
                if(tempAddress.length() != 0) {
                    part = '.' + part;
                }
                tempAddress.append(part);
                backTracking(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }

}
