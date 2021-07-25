package part_1.medium.binarysearch;

public class GetNumberOfK_newcoderJZ37 {

    public int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(nums[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
