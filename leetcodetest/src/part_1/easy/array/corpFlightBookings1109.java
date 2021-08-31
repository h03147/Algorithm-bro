package part_1.easy.array;

public class corpFlightBookings1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分法 前缀和的思路
        int[] nums = new int[n];
        for(int[] book : bookings) {
            nums[book[0] - 1] += book[2];
            if(book[1] < n) {
                nums[book[1]] -= book[2];
            }
        }

        for(int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
