class Solution {
public:
    int findMin(vector<int>& nums) {
        int n=nums.size();
        
        int lo=0, hi=n-1;
        
        if(nums[lo]<nums[hi])
            return nums[lo];
        
        while(lo+1<hi)
        {
            int mid=lo+(hi-lo)/2;
            
            if(nums[lo]<nums[mid])
                lo=mid;
            else
                hi=mid;
        }
        
        if(lo==hi)
            return nums[lo];
        else
            return min(nums[lo],nums[hi]);
    }
};