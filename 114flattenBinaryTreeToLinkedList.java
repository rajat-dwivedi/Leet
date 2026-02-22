//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114flattenBinaryTreeToLinkedList

//m0 O(N) O(N) 
class Solution {
    private void preOrder(TreeNode root, Queue<TreeNode> list){
        if(root==null) return;
        list.offer(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        preOrder(root, q);
        while(q.size()>0){
            TreeNode top = q.poll();
            top.left=null;
            if(q.size()>0){
                top.right = q.peek();
            }
        }
    }
}

//m1 - TC O(N) SC O(N)
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root == null)
            return;
        st.push(root);
        while(st.size()>0){
            TreeNode cur = st.pop();
            if(cur.right!=null){
                st.push(cur.right);
            }
            if(cur.left!=null){
                st.push(cur.left);
            }
            if(st.size()>0) cur.right = st.peek();
            cur.left = null;
        }
    }
}

//m3 morries traversal approach
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null){
            if(cur.left!=null){
                prev = cur.left;
                //going to the rightmost node in the left subtree of the root
                while(prev.right!=null)
                   { prev = prev.right;}
                //making the rightmost node in the left substree to point to the roots, right tree. 
                prev.right = cur.right;
                //making the root right point to root left
                cur.right = cur.left;
                //removing the connection of root to its left. 
                cur.left = null;
            }
            //moving on to the right of the root. 
            cur = cur.right;
        }
    }
}