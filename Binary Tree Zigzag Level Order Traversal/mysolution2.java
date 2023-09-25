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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        boolean direction=false;
        
        Deque<TreeNode> dq=new ArrayDeque();
        
        dq.addLast(root);
        
        while(!dq.isEmpty())
        {
            int size=dq.size();
            List<Integer> list=new ArrayList();
            
            if(direction)
            {
                direction=false;
                for(int i=1;i<=size;i++)
                {
                    TreeNode temp=dq.pollLast();
                    list.add(temp.val);
                    
                    if(temp.right!=null)
                        dq.addFirst(temp.right);
                    
                    if(temp.left!=null)
                        dq.addFirst(temp.left);
                }
            }
            else
            {
                direction=true;
                for(int i=1;i<=size;i++)
                {
                    TreeNode temp=dq.pollFirst();
                    list.add(temp.val);
                    
                    if(temp.left!=null)
                        dq.addLast(temp.left);
                    
                    if(temp.right!=null)
                        dq.addLast(temp.right);
                }   
            }
            
            ans.add(list);
            
        }
        
        return ans;
        
    }
}