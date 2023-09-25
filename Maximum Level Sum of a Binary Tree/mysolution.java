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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> queue=new LinkedList();
        
        queue.add(root);
        
        int max_sum=Integer.MIN_VALUE, max_level=1;
        int curr_level=1;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            int sum=0;
            
            for(int i=0;i<n;i++)
            {
                TreeNode temp=queue.remove();
                sum+=temp.val;
                
                if(temp.left!=null)
                    queue.add(temp.left);
                
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            
            if(sum>max_sum)
            {
                max_sum=sum;
                max_level=curr_level;
            }
            
            curr_level++;
        }
        
        return max_level;
    }
}