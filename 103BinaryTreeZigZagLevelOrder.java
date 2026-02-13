//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//103BinaryTreeZigZagLevelOrder
class Solution {
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean normalorder = false;
        while(!q.isEmpty()){
            int size = q.size();            
            LinkedList<Integer> levelValues = new LinkedList<>();  
            normalorder = !normalorder;
            while(size > 0){
                size--;       
                TreeNode cur = q.poll();  
                if(normalorder)
                    levelValues.offer(cur.val); 
                else
                    levelValues.offerFirst(cur.val);
                
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);      
                                     
            }
            //System.out.println("Level values are "+levelValues);
            list.add(levelValues);
        }
        return list;
    }
}

//m1

class Solution {
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean normalorder = false;
        while(!q.isEmpty()){
            int size = q.size();            
            LinkedList<Integer> levelValues = new LinkedList<>();  
            normalorder = !normalorder;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                levelValues.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            if(normalorder){
                list.add(levelValues);
            }else{
                Collections.reverse(levelValues);
                list.add(levelValues);
            }
            
            //System.out.println("Level values are "+levelValues);
            // list.add(levelValues);
        }
        return list;
    }
}
    