package part_1.medium.bitwiseoperator;

public class FindNumsAppearOnce_swordOffer40 {

    public int[] FindNumsAppearOnce (int[] array) {
        int diff = 0;
        for(int num : array) {
            diff ^= num;
        }
        // 数组中两个只出现一次数的异或结果中最右边的那个位置上的1拿出来了，并且它绝对位置不变
        diff &= -diff;
        int[] res = new int[2];
        for(int num : array) {
            if((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        if(res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }

}
