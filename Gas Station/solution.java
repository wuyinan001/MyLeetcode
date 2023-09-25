class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n=gas.length;
        
        int total_gas=0, curr_gas=0;
        
        int start_station=0;
        int i=0;
        
        while(i<n)
        {
            curr_gas+=gas[i]-cost[i];
            total_gas+=gas[i]-cost[i];
            
            if(curr_gas<0)
            {
                start_station=i+1;
                curr_gas=0;
            }
            
            i++;
        }
        
        return total_gas<0 ? -1 : start_station;
    }
}