//https://leetcode.com/problems/find-bottom-left-tree-value/
//513findBottomLeftTreeValue
//m0 - bfs
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root.left==null && root.right==null) return root.val;
        int prev = 0;
        q.offer(root);
        while(q.size()>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode temp = q.poll();
                prev = temp.val;
                if(temp.right!=null) q.offer(temp.right);
                if(temp.left!=null) q.offer(temp.left);
            }
        }
        return prev;
    }
}