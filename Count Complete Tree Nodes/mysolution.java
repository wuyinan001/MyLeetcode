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
    public int countNodes(TreeNode root) {
        
        int prev=0, sum=0;
        
        Queue<TreeNode> queue=new LinkedList();
        
        if(root!=null)
            queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            if(size!=1&&size!=2*prev)
            {
                sum+=size;
                return sum;
            }
            else
            {
                prev=size;
                sum+=size;
                for(int i=1;i<=size;i++)
                {
                    TreeNode node=queue.remove();
                    
                    if(node.left!=null)
                        queue.add(node.left);
                    
                    if(node.right!=null)
                        queue.add(node.right);
                }
            }
        }
        
        return sum;
    }
}