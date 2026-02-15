//https://leetcode.com/problems/symmetric-tree/
//101symmetricTree
//m0 - recursive
class Solution {
    private boolean check(TreeNode left, TreeNode right){
        //if one is null both should be null
        if(left==null || right==null) return left==right;
        if(left.val!=right.val) return false;
        return (check(left.right, right.left) && check(left.left,right.right));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return true;
        return check(root.left,root.right);
    }
}

//m1 - iterative
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.empty()) {
        TreeNode n1 = stack.pop(), n2 = stack.pop();
        if (n1 == null && n2 == null) continue;
        if (n1 == null || n2 == null || n1.val != n2.val) return false;
        stack.push(n1.left);
        stack.push(n2.right);
        stack.push(n1.right);
        stack.push(n2.left);
    }
    return true;
}