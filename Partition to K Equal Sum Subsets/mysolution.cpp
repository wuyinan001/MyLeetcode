class Solution {
public:
    bool backTrack(vector<int>& nums, int index, int cum, int target, int k, vector<bool>& visited)
    {
        if(k==1)
            return true;
        
        if(target==cum)
            return backTrack(nums,0,0,target,k-1,visited);
        
        for(int i=index;i<nums.size();i++)
        {
            if(nums[i]+cum<=target&&!visited[i])
            {
                visited[i]=true;
                if(backTrack(nums,i+1,cum+nums[i],target,k,visited))
                    return true;
                visited[i]=false;
            }
        }
        
        return false;
    }
    
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int sum1=accumulate(nums.begin(),nums.end(),0);
        int n=nums.size();
        
        if(n<k||sum1%k!=0)
            return false;
        
        vector<bool> visited(n,false);
        int target=sum1/k;
        
        return backTrack(nums,0,0,target,k,visited);
    }
};