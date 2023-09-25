class Solution {
public:
    int rob(vector<int>& nums, int lo, int hi)
    {
        if(lo==hi)
            return nums[lo];
            
        vector<int> L(hi-lo+1,0);
        
        L[0]=nums[lo];
        L[1]=max(nums[lo],nums[lo+1]);
        
        for(int i=2;i<hi-lo+1;i++)
        {
            L[i]=max(L[i-1],L[i-2]+nums[lo+i]);
        }
        
        return L[hi-lo];
    }
    
    int rob(vector<int>& nums) {
        int n=nums.size();
        
        if(n==1)
            return nums[0];
        
        return max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
};