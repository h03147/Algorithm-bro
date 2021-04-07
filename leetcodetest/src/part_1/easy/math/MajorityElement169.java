package part_1.easy.math;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MajorityElement169 {

    public static void main(String[] args) {
        System.out.println(new MajorityElement169().majorityElement(new int[] {3, 2, 3}));
    }


    public int majorityElement(int[] nums) {
        // // 方法一 hash数组（最容易想到的方法）
        // Map<Integer, Integer> count_map = new HashMap<>();
        // int res = 0, n = nums.length;
        // for(int num : nums) {
        //     count_map.put(num, count_map.getOrDefault(num, 0) + 1);
        //     if(count_map.get(num) > n / 2) {
        //         res = num;
        //         break;
        //     }
        // }
        // return res;

        // // 方法二 中位数一定是众数（这里是出现次数大于 n / 2 向下取整）
        // Arrays.sort(nums);
        // return nums[nums.length / 2];

        // 方法三 摩尔投票法
        // 算法思想，从第一个元素开始遍历当前数组，并把第一个元素先当成起始的可能的众数的候选人，
        // 并用一个变量count记录为1，判断如果后面遍历的元素和当前元素相等则count + 1，不想等则
        // count - 1，如果count减到0了我们就换正在遍历的下一个元素为新的众数候选人，count重新
        // 赋值为1，然后重复上述操作。我们分析一下，如果这个元素的count被抵消为0了，那么说明它的
        // 个数并没有超过数组总和的一半（n / 2），不然的话，按找数值相异就一对一抵消原则，整个数
        // 组遍历完，如果它的个数超过了整个数组个数的一半，那它肯定至少还剩一个，也就是count肯定
        // 会大于0
        // int answer = 0, count = 0;
        // int n = nums.length;
        // for(int i = 0; i < n; ++i) {
        //     if(count == 0) {
        //         answer = nums[i];
        //         count++;
        //     } else {
        //         count = (answer == nums[i]) ? count + 1 : count - 1;
        //     }
        // }
        // return answer;
        int answer = nums[0], count = 1;
        int n = nums.length;
        for(int i = 1; i < n; ++i) {
            if(answer == nums[i]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    answer = nums[i];
                    count = 1;
                }
            }
        }
        return answer;
    }

}
