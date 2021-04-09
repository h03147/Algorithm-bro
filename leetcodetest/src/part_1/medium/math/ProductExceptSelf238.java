package part_1.medium.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductExceptSelf238 {

    public static void main(String[] args) {
        int[] num_r = new ProductExceptSelf238().productExceptSelf(new int[] {1, 2, 3, 4});
        List<Integer> res = new ArrayList<>();
        for(int num : num_r) {
            res.add(num);
        }
        System.out.println(res);
    }


    public int[] productExceptSelf(int[] nums) {
        /*
        * 分析题意：本题要求返回结果数组每个对应下标res[i]里存储除了nums[i]之外nums数组其他所有数的乘积，
        * 我们比较容易想到的做法是先把所有的数都乘起来得到总数，然后遍历到每个nums[i]直接除以它就好了，但
        * 是最容易想到的题目偏偏不让你用，还要求时间复杂度为O(n),所以我们不得不去寻求新方法，这里我们提出
        * 的新方法叫左右乘法表法，什么意思呢。也就是我们排除左右边界上的数以外，先从左向右把所有当前在
        / nums[i]左边的数乘起来，存储到结果集的res[i]位置上，然后同理我们再从右向左把所有当前nums[i]右边
        * 的数乘起来，这样我们就巧妙的把每一个数nums[i]左右两边(如果存在)的数的乘积都算出来了。
        * 时间复杂度为 左边 n - 1 右边 n - 1，合起来就是2n - 2，满足线性的时间复杂度O(n)，问题得以解决。
        */
        int n = nums.length;
        // 开辟于nums同样空间的结果集返回数组
        int[] res = new int[n];
        Arrays.fill(res, 1);

        // 先把左乘积的数更新进去
        int left = 1;
        for(int i = 1; i < n; ++i) {
            left *= nums[i - 1];
            res[i] *= left;
        }

        // 在把右乘积的数也更新进去
        int right = 1;
        for(int j = n - 2; j >= 0; --j) {
            right *= nums[j + 1];
            res[j] *= right;
        }

        return res;

    }

}
