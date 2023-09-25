/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        
        if(root==null)
            return ans;
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            for(int i=0;i<n;i++)
            {
                TreeNode t=queue.remove();
                
                if(t.left!=null)
                    queue.add(t.left);
            
                if(t.right!=null)
                    queue.add(t.right);

                if(i==n-1)
                    ans.add(t.val);
            }
            
        }
        
        return ans;
    }
}