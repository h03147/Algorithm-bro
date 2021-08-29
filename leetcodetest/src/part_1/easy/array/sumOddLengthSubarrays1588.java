package part_1.easy.array;

public class sumOddLengthSubarrays1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        // // 方法一 暴力求解
        // int n = arr.length;
        // int sum = 0;
        // for(int start = 0; start < n; ++start) {
        //     for(int length = 1; start + length <= n; length += 2) {
        //         int end = start + length - 1;
        //         for(int i = start; i <= end; ++i) {
        //             sum += arr[i];
        //         }
        //     }
        // }
        // return sum;

        // 方法二 前缀和
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int sum = 0;
        for(int start = 0; start < n; ++start) {
            for(int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                // 得到前缀和数组prefixSums之后，对于 0 ≤ start ≤ end < n，数组arr的下标范围
                // [start,end]的子数组的和为 prefixSums[end + 1] − prefixSums[start]
                sum += prefixSum[end + 1] - prefixSum[start];
            }
        }
        return sum;
    }

}
