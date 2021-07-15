package part_1.medium.tree;

public class pathSum_swordOffer34 {

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backTracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backTracking(TreeNode node, int target, List<Integer> path) {
        if(node == null) return;
        path.add(node.val);
        target -= node.val;
        if(target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backTracking(node.left, target, path);
            backTracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

}
