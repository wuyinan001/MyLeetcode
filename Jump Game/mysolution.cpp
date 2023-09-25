class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int i=n-1;
        for(int j=n-2;j>=0;j--)
        {
            if(nums[j]+j>=i)
            {
                i=j;
            }
        }
        
        return i==0;
    }
};