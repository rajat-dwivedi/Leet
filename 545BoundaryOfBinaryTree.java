//https://leetcode.com/problems/boundary-of-binary-tree/
//545BoundaryOfBinaryTree
class Solution {
    boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null)
        return true;
        else
        return false;
    }
    void addleft(TreeNode node, List<Integer> ans){
        TreeNode cur = node.left;
        while(cur!=null){
            if(isLeaf(cur)==false) ans.add(cur.val);
            if(cur.left!=null) cur = cur.left;
            else cur = cur.right;
        }
    }
    void addRight(TreeNode root, List<Integer> res){
        TreeNode cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(cur!=null){
            if(isLeaf(cur)==false) temp.add(cur.val);
            if(cur.right!=null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for(i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    void addLeaf(TreeNode root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left!=null) addLeaf(root.left, res);
        if(root.right!=null) addLeaf(root.right, res);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(isLeaf(node)==false) ans.add(node.val);
        //first add the left side
        addleft(node, ans);
        //then add all the leaves using the inorder traversal
        addLeaf(node, ans);
        //then add the right boundary in reverse (going from botton to top)
        addRight(node, ans);
        return ans;
    }
}