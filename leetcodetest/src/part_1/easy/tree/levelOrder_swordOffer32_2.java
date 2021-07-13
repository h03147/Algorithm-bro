package part_1.easy.tree;

public class levelOrder_swordOffer32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret_list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if(!list.isEmpty()) {
                ret_list.add(list);
            }
        }
        return ret_list;
    }

}
