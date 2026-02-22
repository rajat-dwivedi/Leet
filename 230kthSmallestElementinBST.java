//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230kthSmallestElementinBST

//m0 - using inorder traversal as inorder traversal of bst is sorted

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || st.size()>0){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(--k==0) return root.val;
            root = root.right;
        }
        return 0;
    }
}