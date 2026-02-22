//https://leetcode.com/problems/validate-binary-search-tree/
//98validateaBST

//m0 

class Solution {
    public boolean isValidBST(TreeNode root) {
     if(root==null)
     return true;
     TreeNode pre = null;
     Stack<TreeNode> st = new Stack<>();
    //  st.push(root);
     while(root!=null || st.size()>0){
         while(root!=null){
             st.push(root);
             root = root.left;
         }
         root = st.pop();
         if(pre!=null && pre.val>=root.val){
             return false;
         }
         pre = root;
         root  = root.right;
     }   
     return true;
    }
}

//m1 - recurive with bounds 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        
        return helper(node.left, min, node.val) &&
               helper(node.right, node.val, max);
    }
}