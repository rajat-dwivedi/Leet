//https://leetcode.com/problems/binary-tree-right-side-view/
//199BinrayTreeRightSideView
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while(q.size()>0){
            int len = q.size();
            level++;
            for(int i=0;i<len;i++){
                TreeNode top = q.poll();
                if(level>res.size()){
                    res.add(top.val);
                }
                if(top.right!=null)q.offer(top.right);
                if(top.left!=null)q.offer(top.left);
            }
        }
        return res;
    }
}