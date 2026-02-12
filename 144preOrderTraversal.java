//https://leetcode.com/problems/binary-tree-preorder-traversal/
//144preOrderTraversal
//m0 - iterative 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root1) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root1==null)
            return res;
        st.push(root1);
        
        while(st.size()>0){
            TreeNode root = st.peek(); st.pop();
            res.add(root.val);
            
            if(root.right!=null){
                st.push(root.right);
            }
            
            if(root.left!=null){
                st.push(root.left);
            }
        }
        
        return res;
    }
}

//m1 - recursive
class Solution {
    public void solve(TreeNode root, List<Integer> res){
        if(root==null)
            return;
        res.add(root.val);
        solve(root.left,res);
        solve(root.right, res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }
}