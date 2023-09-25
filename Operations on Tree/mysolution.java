class LockingTree {
    
    int V;
    List<Integer>[] adj;
    Map<Integer,Integer> map;
    int[] parent;
    
    public LockingTree(int[] parent) {
        
        V=parent.length;
        adj=new List[V];
        for(int i=0;i<V;i++)
            adj[i]=new ArrayList();
        
        for(int i=0;i<V;i++)
        {
            if(parent[i]!=-1)
            {
                adj[i].add(parent[i]);
                adj[parent[i]].add(i);
            }
        }
        
        map=new HashMap();
        for(int i=0;i<V;i++)
            map.put(i,-1);
        
        this.parent=parent;
    }
    
    public boolean lock(int num, int user) {
     
        if(map.get(num)==-1)
        {
            map.put(num,user);
            return true;
        }
        else 
            return false;
    }
    
    public boolean unlock(int num, int user) {
        
        if(map.get(num)==user)
        {
            map.put(num,-1);
            return true;
        }
        else
            return false;
    }
    
    private boolean upDFS(int num)
    {
        if(map.get(num)!=-1)
            return false;
        
        if(parent[num]!=-1)
            return upDFS(parent[num]);
        else
            return true;
    }
    
    public boolean upgrade(int num, int user) {
        
        if(!upDFS(num))
            return false;
        
        boolean ans=false;
        Queue<Integer> queue=new LinkedList();
        queue.add(num);
        
        while(!queue.isEmpty())
        {
            int curr=queue.remove();
            if(map.get(curr)!=-1)
            {
                ans=true;
                map.put(curr,-1);
            }
            
            for(int v:adj[curr])
            {
                if(v!=parent[curr])
                    queue.add(v);
            }
        }
        
        if(ans)
            map.put(num,user);
        
        return ans;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */