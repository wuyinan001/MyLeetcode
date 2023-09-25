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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
            return result;
        
        queue.add(root);
        
        int level=0;
        
        while(!queue.isEmpty())
        {
            
            int n=queue.size();
            
            result.add(new ArrayList<>());
            
            for(int i=0;i<n;i++)
            {
                TreeNode t=queue.remove();
                result.get(level).add(t.val);
                
                if(t.left!=null)
                    queue.add(t.left);
                if(t.right!=null)
                    queue.add(t.right);
            }
            
            level++;
                
        }
        
        return result;
    }
}