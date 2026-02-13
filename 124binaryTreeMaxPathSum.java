//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//124binaryTreeMaxPathSum
class Solution {
    public int solve(TreeNode root, int[] res){
        if(root==null)
            return 0;
        
        int left = Math.max(0,solve(root.left, res));
        int right = Math.max(0,solve(root.right, res));
        
        res[0] = Math.max(res[0],root.val+left+right);

        return root.val+(Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        int t = solve(root, res);
        return res[0];
    }
}

