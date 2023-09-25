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
    
    private class Graph
    {
        int V;
        Map<TreeNode,List<TreeNode>> adj;
        Map<TreeNode, Boolean> visited;
        List<Integer> ans;
        
        private void buildGraph(TreeNode root)
        {
            if(root==null)
                return;
            
            visited.put(root,false);
            
            if(!adj.containsKey(root))
            {
                List<TreeNode> l=new ArrayList();
                adj.put(root,l);
            }
            
            if(root.left!=null)
            {
                adj.get(root).add(root.left);
                
                if(!adj.containsKey(root.left))
                {
                    List<TreeNode> list=new ArrayList();
                    list.add(root);
                    adj.put(root.left,list);
                }
                else
                    adj.get(root.left).add(root);
            }
            
            if(root.right!=null)
            {
                adj.get(root).add(root.right);
                
                if(!adj.containsKey(root.right))
                {
                    List<TreeNode> list=new ArrayList();
                    list.add(root);
                    adj.put(root.right,list);
                }
                else
                    adj.get(root.right).add(root);
            }
            
            buildGraph(root.left);
            buildGraph(root.right);
        }
        
        public Graph(TreeNode root)
        {
            adj=new HashMap();
            visited=new HashMap();
            buildGraph(root);
            
            ans=new ArrayList();
        }
        
        public List<Integer> bfs(TreeNode root, int K)
        {
            Queue<TreeNode> queue=new LinkedList();
            
            queue.add(root);
            visited.put(root,true);
            int depth=0;
            
            while(!queue.isEmpty())
            {
                int n=queue.size();
                
                for(int i=0;i<n;i++)
                {
                    TreeNode temp=queue.remove();
                    
                    if(depth==K)
                        ans.add(temp.val);
                    
                    if(!adj.get(temp).isEmpty())
                    {
                        for(TreeNode t:adj.get(temp))
                        {
                            if(!visited.get(t))
                            {
                                queue.add(t);
                                visited.put(t,true);
                            }
                        }
                    }
                    
                }
                
                depth++;
                
            }
            
            return ans;
        }
    }
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
            Graph g=new Graph(root);
            return g.bfs(target,K);
        
    }
}