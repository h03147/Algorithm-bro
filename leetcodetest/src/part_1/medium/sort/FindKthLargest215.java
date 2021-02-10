package part_1.medium.sort;

public class FindKthLargest215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 方法一 最简单的方法， 调用java自带的工具类
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        // 方法二 堆的方法来求解
        /*
         * 分析思路：根据堆的特性，比如这题我们拿小顶堆来解题，
         * 那么堆顶元素永远是当前堆中最小的元素。
         * 就用nums构建一个小顶堆，让堆顶不停的poll()弹出
         * 假设nums长度为n，我们就弹出n - k 个元素剩下的就是
         * 倒数k个最大的元素了，此时的堆顶就是我们要的第k大的
         * 元素。
         */
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        // for(int item : nums) {
        //     pq.add(item);
        //     if(pq.size() > k) {
        //         pq.poll(); // 取得当前堆顶元素并且将其从堆中删除
        //     }
        // }
        // return pq.peek();

        // 方法三 快排的思想来求解
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int j = partition(nums, low, high);
            if(j == k) {
                break;
            } else if(j < k) {
                low = j + 1;
            } else {
                high = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int low, int high) {
        int i = low, j = high + 1;
        while(true) {
            while(a[++i] < a[low] && i < high);
            while(a[--j] > a[low] && j > low);
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    // 交换位置的算法
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
