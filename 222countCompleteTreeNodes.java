//https://leetcode.com/problems/count-complete-tree-nodes/
//222countCompleteTreeNodes

//m0 - bfs O(N)

class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode temp = q.poll();
                count++;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
        return count;
    }
}

//m1 - O(logN*logN)

class Solution {
    public int lh(TreeNode root){
        if(root==null)
            return 0;
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int rh(TreeNode root){
        if(root==null)
            return 0;
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        int ans = 0;
        if(root==null)
            return 0;
        int lheight = lh(root);
        int rheight = rh(root);
        if(lheight==rheight){
            ans = (1<<lheight)-1;
            return ans;
        }else{
            ans = 1 + countNodes(root.left)+countNodes(root.right);
        }
        return ans;
    }
}

//m1 - O(logn*logn) - using the height of a perfect bt formula

class Solution {
    public int lh(TreeNode root){
        if(root==null)
            return 0;
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int rh(TreeNode root){
        if(root==null)
            return 0;
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        int ans = 0;
        if(root==null)
            return 0;
        int lheight = lh(root);
        int rheight = rh(root);
        if(lheight==rheight){
            ans = (1<<lheight)-1;
            return ans;
        }else{
            ans = 1 + countNodes(root.left)+countNodes(root.right);
        }
        return ans;
    }
}