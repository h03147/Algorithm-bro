package part_1.medium.twopoint;

public class JudgeSquareSum633 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
    }

    public static boolean judgeSquareSum(int c) {
        if(c < 0) {
            return false;
        }
        int low = 0, high = (int) Math.sqrt(c);
        while(low <= high) {
            int sum = low * low + high * high;
            if(sum == c) {
                return true;
            }else if(sum < c) {
                low++;
            }else {
                high--;
            }
        }
        return false;
    }
}
