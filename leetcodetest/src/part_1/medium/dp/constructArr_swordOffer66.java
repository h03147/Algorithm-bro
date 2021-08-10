package part_1.medium.dp;

public class constructArr_swordOffer66 {

    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        // 先从左到右把每个B[i]左边的所有数乘积算出来，存到对应位置
        for(int i = 0, product = 1; i < n; product *= a[i], ++i) {
            B[i] = product;
        }
        // 再从右向左把每个B[i]右边的所有数乘积算出来，累乘到上一步已经算好每个位置左边乘积的数上
        for(int i = n - 1, product = 1; i >= 0; product *= a[i], --i) {
            B[i] *= product;
        }
        return B;
    }

}
