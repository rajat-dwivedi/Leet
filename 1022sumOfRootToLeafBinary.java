//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//1022sumOfRootToLeafBinary
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        
        int prev = 0;
        int sum = solve(root,prev);
        
        return sum;
    }
    public int solve(TreeNode root, int prev){
        if(root==null) return 0;
        
        prev = 2*prev+root.val;
        if(root.left==null && root.right==null)
            return prev;
        
        return solve(root.left, prev)+solve(root.right, prev);
    }
    
}