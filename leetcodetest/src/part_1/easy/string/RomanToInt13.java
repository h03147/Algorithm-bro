package part_1.easy.string;

public class RomanToInt13 {

    public int romanToInt(String s) {

        // 分析题意：hash表映射，遍历字符串，如果下一个字符比当前大，说明
        // 是减法，反之做加法。
        Map<Character, Integer> symbolValues = new HashMap<>();
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);

        int n = s.length(), res = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(i < n - 1 && symbolValues.get(s.charAt(i)) < symbolValues.get(s.charAt(i + 1))) {
                res -= symbolValues.get(s.charAt(i));
            } else {
                res += symbolValues.get(s.charAt(i));
            }
        }
        return res;
    }

}
