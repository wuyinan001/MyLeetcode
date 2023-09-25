class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        start=0
        totalgas=0
        currgas=0
        
        for i in range(len(gas)):
            totalgas+=gas[i]-cost[i]
            currgas+=gas[i]-cost[i]
            if currgas<0:
                currgas=0
                start=i+1
        
        if totalgas>=0:
            return start
        else:
            return -1