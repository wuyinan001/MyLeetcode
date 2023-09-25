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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
            return result;
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        
        boolean reverse=false;
        int level=0;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            result.add(new ArrayList<>());
            
            if(reverse==false)
            {
                for(int i=0;i<n;i++)
                {
                    TreeNode t=queue.remove();
                    result.get(level).add(t.val);
                    
                    if(t.left!=null)
                        queue.add(t.left);
                    if(t.right!=null)
                        queue.add(t.right);
                }
            }
            else
            {
                Stack<Integer> stack=new Stack<>();
                
                for(int i=0;i<n;i++)
                {
                    TreeNode t=queue.remove();
                    stack.push(t.val);
                    
                    if(t.left!=null)
                        queue.add(t.left);
                    if(t.right!=null)
                        queue.add(t.right);
                }
                
                while(!stack.isEmpty())
                {
                    result.get(level).add(stack.pop());
                }
            }
            
            reverse=!reverse;
            level++;
        }
        
        return result;
    }
}