//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//653TwoSum4

//m1 
//using inoder traversal, saving it in array, then doing search on it
class Solution {
    private void inorder(TreeNode root, List<Integer> vals){
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || st.size()>0){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            vals.add(root.val);
            root = root.right;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        int i = 0, j = vals.size()-1;
        while(i<j){
            if(vals.get(i)+vals.get(j)==k) return true;
            else if(vals.get(i)+vals.get(j)<k) i++;
            else j--;
        }
        return false;
    }
}

//m2
public class BSTIterator{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = false;
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    
    public boolean hasNext(){
        return !st.isEmpty();
    }
    
    public int next(){
        TreeNode temp = st.pop();
        if(reverse == false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
    
    private void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse == true){
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
    
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        
        int i = l.next();
        int j = r.next();
        
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i = l.next();
            else j = r.next();
        }
        
        return false;
    }
}