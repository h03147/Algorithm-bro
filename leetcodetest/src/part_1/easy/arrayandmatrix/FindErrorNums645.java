package part_1.easy.arrayandmatrix;

public class FindErrorNums645 {

    public int[] findErrorNums(int[] nums) {
        // 用数组桶排序 统计每个数出现的次数，次数为2的就是重复的，次数为0的就是丢失的
        int[] cnt = new int[nums.length + 1];
        for(int num : nums) {
            cnt[num]++;
        }
        int[] result = new int[2];
        for(int i = 1; i < cnt.length; ++i) {
            if(cnt[i] == 1) {
                continue;
            } else if(cnt[i] == 2) {
                result[0] = i;
            } else {
                result[1] = i;
            }
        }
        return result;
    }

}
