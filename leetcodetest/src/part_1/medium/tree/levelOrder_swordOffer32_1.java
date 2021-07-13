package part_1.medium.tree;

public class levelOrder_swordOffer32_1 {

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ret_list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                ret_list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        int[] ret = new int[ret_list.size()];
        int idx = 0;
        for(int num : ret_list) {
            ret[idx++] = num;
        }
        return ret;
    }

}
