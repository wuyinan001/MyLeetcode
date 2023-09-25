class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n=nums.size();
        vector<int> stack;
        int l=n, r=-1;
        
        for(int i=0;i<n;i++)
        {
            while(!stack.empty()&&nums[i]<nums[stack.back()])
            {
                l=min(l,stack.back());
                stack.pop_back();
            }
            stack.push_back(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.empty()&&nums[i]>nums[stack.back()])
            {
                r=max(r,stack.back());
                stack.pop_back();
            }
            stack.push_back(i);
        }
        
        if(l<=r)
            return r-l+1;
        else
            return 0;
    }
};