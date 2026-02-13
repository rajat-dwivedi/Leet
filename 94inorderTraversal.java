//https://leetcode.com/problems/binary-tree-inorder-traversal/
//94inorderTraversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || st.size()>0){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}