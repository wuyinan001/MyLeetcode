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
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> ans=new ArrayList<>();
        
        if(n==0)
            return ans;
        
        return generateTrees(1,n);
    }
    
    private List<TreeNode> generateTrees(int low, int high)
    {
        List<TreeNode> ans=new ArrayList<>();
        
        if(low==high)
        {
            ans.add(new TreeNode(low));
            return ans;
        }
        
        if(low>high)
        {
            ans.add(null);
            return ans;
        }
            
        
        for(int i=low;i<=high;i++)
        {   
            for(TreeNode left:generateTrees(low,i-1))
            {
                for(TreeNode right:generateTrees(i+1,high))
                {
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    ans.add(root);
                }
            }
        }
        
        //System.out.println("low "+low+"\nhigh "+high+"\nans ");
        //print(ans);
        return ans;
            
    }
    
    private void print(List<TreeNode> ans)
    {
        for(TreeNode t:ans)
        {
            printTree(t);
            System.out.println();
        }
            
    }
    
    private void printTree(TreeNode t)
    {
        if(t==null)
        {
            System.out.print("null ");
            return;
        }
            
        
        System.out.print(t.val+" ");
        printTree(t.left);
        printTree(t.right);
    }
}