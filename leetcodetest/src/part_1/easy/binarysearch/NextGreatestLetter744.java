package part_1.easy.binarysearch;

public class NextGreatestLetter744 {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'f'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        /*
         * 分析题意：题目要求在给定有序列表中找到比target目标字母大的
         * 最小的字母，已知有序，那么我们就可以考虑用二分查找法来求值。
         */
        int size = letters.length;
        int low = 0, high = size - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            // 因为我们要找到第一个比目标字母大的字母并非找目标字母，所以只要当前字母
            // 比目标字母小于或等于都归为一种情况，反之则是另一种情况。
            if(letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // 结束条件是high在low左边一位，故第一个大约目标值的位置应该为low指针位置，
        // 但是如果low指针一直走到了列表结尾也没找到大于target的最小字母，那就返回
        // 第一个字符就行。
        return low < size ? letters[low] : letters[0];
    }
}
