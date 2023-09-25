class Solution {
    
    Map<Integer,Integer> map=new HashMap();
    
    // Find the index of smallest entry arr[j]>=arr[i] and j>i
    // If there are multiple smallest entries, return the smallest j
    private int[] findOddNext()
    {
        int[] ans=new int[map.size()];
        
        for(int i=0;i<ans.length;i++)
            ans[i]=-1;
        
        List<Integer> list=new ArrayList(map.keySet());
        
        Collections.sort(list,new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                if(map.get(a1)==map.get(a2))
                    return a1-a2;
                
                return map.get(a1)-map.get(a2);
            }
            
        });
        
        Stack<Integer> stack=new Stack();
        
        for(int i:list)
        {
            while(!stack.isEmpty()&&i>stack.peek())
                ans[stack.pop()]=i;
            stack.push(i);
        }
        
        return ans;
    }
    
    // Find the index of largest entry arr[j]<=arr[i] and j>i
    // If there are multiple largest entries, return the smallest j
    private int[] findEvenNext()
    {
        int[] ans=new int[map.size()];
        
        for(int i=0;i<ans.length;i++)
            ans[i]=-1;
        
        List<Integer> list=new ArrayList(map.keySet());
        
        Collections.sort(list,new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                if(map.get(a1)==map.get(a2))
                    return a1-a2;
                
                return map.get(a2)-map.get(a1);
            }
            
        });
        
        Stack<Integer> stack=new Stack();
        
        for(int i:list)
        {
            while(!stack.isEmpty()&&i>stack.peek())
                ans[stack.pop()]=i;
            stack.push(i);
        }
        
        return ans;
    }
    
    private void print(int[] a)
    {
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }
    
    public int oddEvenJumps(int[] arr) {
        
        int n=arr.length;
        
        for(int i=0;i<n;i++)
            map.put(i,arr[i]);
        
        int[] oddNext=findOddNext();
        int[] evenNext=findEvenNext();
        
        //print(oddNext);
        //print(evenNext);
        
        // odd[i]: true if it is possible to odd jump to the last index from i; 
        // false if it is not possible to odd jump to the last index from i
        boolean[] odd=new boolean[n];
        // even[i]: true if it is possible to even jump to the last index from i; 
        // false if it is not possible to even jump to the last index from i
        boolean[] even=new boolean[n];
        
        odd[n-1]=true;
        even[n-1]=true;
        
        int count=0;
        
        for(int i=n-2;i>=0;i--)
        {
            if((oddNext[i]!=-1)&&even[oddNext[i]])
                odd[i]=true;
            
            if((evenNext[i]!=-1)&&odd[evenNext[i]])
                even[i]=true;
            
            if(odd[i])
                count++;
        }
        
        // add 1 because the last entry always counts
        return count+1;
    }
}