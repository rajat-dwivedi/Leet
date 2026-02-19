//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
105constructBinaryTreeFromInorder&PreorderTraversal

//if we have a preorder and a postorder then we cannot have a unique binary tree

class Solution {
    public TreeNode solve(int[] preorder, int prestart,int preend,int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hm ){
        if(prestart>preend || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        //the position in inorder array where the root value is located. 
        int inRoot = hm.get(preorder[prestart]);
        int numsLeft = inRoot-inStart;
        
        root.left = solve(preorder, prestart+1, prestart+numsLeft, inorder, inStart, inRoot-1, hm);
        
        root.right = solve(preorder, prestart+numsLeft+1, preend, inorder, inRoot+1, inEnd, hm);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = solve(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,hm);
        
        return root;
    }
}