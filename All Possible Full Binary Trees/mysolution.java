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
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        List<TreeNode> ans=new ArrayList();
        
        if(n%2==0)
            return ans;
        
        List<TreeNode>[] list=new List[n+1];
        
        for(int i=0;i<=n;i++)
            list[i]=new ArrayList();
        
        list[1].add(new TreeNode(0));
        
        for(int i=3;i<=n;i++)
        {
            if(i%2!=0)
            {
                for(int j=1;j<=i-2;j+=2)
                {
                    for(TreeNode t1:list[j])
                        for(TreeNode t2:list[i-j-1])
                        {
                            TreeNode root=new TreeNode(0);
                            root.left=t1; 
                            root.right=t2; 
                            list[i].add(root);
                        }
                    
                }
            }
        }
        
        return list[n];
    }
}