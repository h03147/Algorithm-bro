package part_1.medium.tree;

public class levelOrder_swordOffer32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> t_list = new ArrayList<>();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                t_list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if(t_list.size() != 0) {
                if(reverse) {
                    Collections.reverse(t_list);
                }
                list.add(t_list);
            }
            reverse = !reverse;
        }
        return list;
    }

}
