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
    
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null)
            return 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Queue<TreeNode> queue=new LinkedList<>();
        
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode temp=queue.remove();
            
            pq.add(temp.val);
            
            if(temp.left!=null)
                queue.add(temp.left);
            
            if(temp.right!=null)
                queue.add(temp.right);
            
        }
        
        while(k>1)
        {
            pq.poll();
            k--;
        }
            
        return pq.peek();
        
    }
}