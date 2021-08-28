package part_1.easy.array;

public class runningSum1480 {

    public int[] runningSum(int[] nums) {
        // // 方法一 中间变量找前序和累加
        // int size = nums.length;
        // int[] res = new int[size];
        // int sum = 0;
        // for(int i = 0; i < size; ++i) {
        //     sum += nums[i];
        //     res[i] += sum;
        // }
        // return res;

        // 方法二 从nums中第二个数开始，原地加前序结果和
        int size = nums.length;
        for(int i = 1; i < size; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
