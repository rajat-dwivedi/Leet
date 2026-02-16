//https://leetcode.com/problems/binary-tree-paths/
//257BinaryTreePaths
class Solution {
    private void solve(TreeNode root, StringBuilder sb, List<String> res){
        if(root==null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        
        //if its a leaf node then just add the temp string to result
        if(root.left==null && root.right==null){
            res.add(sb.toString());
        }else{
            sb.append("->");
            solve(root.left, sb, res);
            solve(root.right, sb, res);
        }
        sb.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        StringBuilder sb = new StringBuilder();
        solve(root, sb, res);
        return res;
    }
}