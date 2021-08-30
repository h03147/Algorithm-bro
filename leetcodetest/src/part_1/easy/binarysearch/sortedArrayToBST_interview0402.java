package part_1.easy.binarysearch;

public class sortedArrayToBST_interview0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 二分法，尽量均分左右子树使得高度最小
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);
        return node;
    }

}
