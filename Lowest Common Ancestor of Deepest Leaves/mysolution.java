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
    
    private TreeNode ans;
    
    private int helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
            return 0;
            
        int left=0,right=0,mid=0;
        
        if(root==p||root==q)
            mid=1;
        
        left=helper(root.left,p,q);
        right=helper(root.right,p,q);
        
        if(mid==1&&left==1||mid==1&&right==1||left==1&&right==1)
            ans=root;
            
        return left+mid+right;
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q)
    {
        helper(root,p,q);
        
        return ans;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        if(root==null)
            return null;
        
        Queue<TreeNode> queue=new LinkedList();
        
        queue.add(root);
        
        Map<TreeNode,TreeNode> map=new HashMap();
        
        List<List<TreeNode>> list=new ArrayList();
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            List<TreeNode> temp=new ArrayList();
            
            for(int i=0;i<n;i++)
            {
                TreeNode t=queue.remove();
                temp.add(t);
                
                if(t.left!=null)
                {
                    map.put(t.left,t);
                    queue.add(t.left);
                }
                    
                
                if(t.right!=null)
                {
                    map.put(t.right,t);
                    queue.add(t.right);
                }
            }
            
            list.add(temp);
        }
        
        if(list.get(list.size()-1).size()==1)
            return list.get(list.size()-1).get(0);
        else
        {
            List<TreeNode> last=list.get(list.size()-1);
            TreeNode ans=last.get(0);
            
            for(int i=1;i<last.size();i++)
            {
                ans=lca(root,ans,last.get(i));
            }
            
            return ans;
        }
            
        
    }
}