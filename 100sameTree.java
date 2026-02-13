//https://leetcode.com/problems/same-tree/
//100sameTree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p==null && q==null)
        //     return true;
        if(p==null || q==null)
            return p==q;
        if(p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        else
            return false;
    }
}