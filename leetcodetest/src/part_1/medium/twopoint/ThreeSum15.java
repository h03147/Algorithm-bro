package part_1.medium.twopoint;

public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 数组为空或者个数小于等于2都不满足题意
        if(nums == null || nums.length <= 2) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; ++i) {
            if(nums[i] > 0) break; // 排序后的数组第一个数就大于0了，和后面更大的数相加更不可能等于0
            if(i > 0 && nums[i] == nums[i - 1]) continue; // 第一数有重复的就跳过
            int target = -nums[i]; // 让第一个数为target，之后第二个数加第三个数如果等于-target，三者相加即为0
            int left = i + 1, right = n - 1;
            // 将问题又三数之转换成了两数之和，用双指针解题即可
            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 低位指针右移，高位指针左移，但是需要过滤掉重复的元素
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if(nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;

}
