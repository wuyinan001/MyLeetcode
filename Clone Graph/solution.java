/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return null;
        
        // Key: orginal node;  Value: the node copy from the node in key
        Map<Node,Node> map=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        
        queue.add(node);
        map.put(node,new Node(node.val,new ArrayList<>()));
        
        while(!queue.isEmpty())
        {
            Node temp=queue.remove();
            
            for(Node n:temp.neighbors)
            {
                if(!map.containsKey(n))
                {
                    map.put(n,new Node(n.val,new ArrayList<>()));
                    queue.add(n);
                }
                
                map.get(temp).neighbors.add(map.get(n));
            }
            
        }
        
        return map.get(node);
    }
}