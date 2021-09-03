package part_1.medium.sort;

public class smallestK_interview17_14 {

    public int[] smallestK(int[] arr, int k) {

        // // 方法一 调包侠
        // Arrays.sort(arr);
        // int[] res = new int[k];
        // for(int i = 0; i < k; ++i) {
        //     res[i] = arr[i];
        // }
        // return res;

        // 方法二 自己写排序算法，这里以快速排序为例子
        sort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for(int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    // QuickSort模板
    private void sort(int[] arr, int left, int right) {
        if(left < right) {
            int key = arr[left];
            int i = left, j = right;
            while(i < j) {
                while(i < j && arr[j] >= key) {
                    j--;
                }
                if(i < j) {
                    arr[i] = arr[j];
                }
                while(i < j && arr[i] <= key) {
                    i++;
                }
                if(i < j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = key;

            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

}
