class Solution {
    
    // min transfers to set all nums to 0 in the given array staring at index
    private int backTrack(int index, int[] arr)
    {
        if(index==arr.length)
            return 0;
        
        if(arr[index]==0)
            return backTrack(index+1,arr);
        
        int ans=Integer.MAX_VALUE;
        int n=arr.length;
        int curr=arr[index];
        
        for(int i=index+1;i<n;i++)
        {
            // If arr[i] is 0 or arr[i] has the same sign as arr[index], then it is meaningless(or not the min transfers) to transfer arr[index] to arr[i] 
            if(arr[i]*curr>=0)
                continue;
            
            arr[i]+=curr;
            ans=Math.min(1+backTrack(index+1,arr),ans);
            arr[i]-=curr;
        }
        
        return ans;
    }
    
    public int minTransfers(int[][] transactions) {
        
        Map<Integer,Integer> map=new HashMap();
        
        for(int[] t:transactions)
        {
            int from=t[0], to=t[1], amount=t[2];
            
            map.put(from,map.getOrDefault(from,0)-amount);
            map.put(to,map.getOrDefault(to,0)+amount);
                
        }
        
        int[] arr=new int[map.size()];
        
        int k=0;
        for(int key:map.keySet())
            arr[k++]=map.get(key);
        
        return backTrack(0,arr);
    }
}