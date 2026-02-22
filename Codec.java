//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//297serializeDeserializeBT

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            TreeNode temp = q.poll();
            if(temp!=null){
                sb.append(temp.val);
                sb.append(",");
                q.offer(temp.left);
                q.offer(temp.right);
            }else{
                sb.append("$");
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.equals("")) return null;
        String[] tree = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        q.offer(root);
        for(int i=1;i<tree.length; i++){
            TreeNode temp = q.poll();
            if(!tree[i].equals("$")){
                TreeNode left = new TreeNode(Integer.valueOf(tree[i]));
                temp.left = left;
                q.offer(left);
            }
            if(!tree[++i].equals("$")){
                TreeNode right = new TreeNode(Integer.valueOf(tree[i]));
                temp.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}