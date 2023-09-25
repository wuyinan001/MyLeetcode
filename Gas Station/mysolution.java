class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n=gas.length;
        
        for(int i=0;i<n;i++)
        {
            if(gas[i]<cost[i])
                continue;
            
            int j=(i+1)%n;
            int curr=gas[i]-cost[i]+gas[j];
                
            while(j!=i)
            {
                if(curr<cost[j])
                    break;
                
                curr=curr-cost[j]+gas[(j+1)%n];
                j=(j+1)%n;
            }
            
            if(j==i)
                return i;
        }
        
        return -1;
    }
}