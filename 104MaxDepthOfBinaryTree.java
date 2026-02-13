//https://leetcode.com/problems/maximum-depth-of-binary-tree/

//m0 - recursive
class Solution {
    private int solve(TreeNode root){
        if(root==null) return 0;
        int lh = solve(root.left);
        int rh = solve(root.right);
        return 1+Math.max(lh,rh);
    }
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
}

//m1 - iterative 
class Solution {
    public int maxDepth(TreeNode root) {
        // return solve(root);
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.offer(root);
        int depth = 0;
        while(q.size()>0){
            depth++;
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
        return depth;
    }
}