/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int sum = root.val;
        if(root.left!=null){
            sum+=rob(root.left.left);
            sum+=rob(root.left.right);
        }
        if(root.right!=null){
            sum+=rob(root.right.left);
            sum+=rob(root.right.right);
        }

        int lsum = rob(root.left)+rob(root.right);

        int ans = Math.max(sum, lsum);

        map.put(root,ans);
        return ans;
    }
}
//optimized
class Solution {
public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);
    int[] res = new int[2];

    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = root.val + left[0] + right[0];
    
    return res;
}
}