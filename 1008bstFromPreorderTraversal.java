//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//1008bstFromPreorderTraversal

class Solution {
    public TreeNode solve(int[] a, int bound, int[] i){
        if(i[0]==a.length || a[i[0]]>bound) return null;
        TreeNode root = new TreeNode(a[i[0]++]);
        root.left = solve(a, root.val, i);
        root.right = solve(a, bound, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] a) {
        return solve(a,Integer.MAX_VALUE, new int[]{0});
    }
}