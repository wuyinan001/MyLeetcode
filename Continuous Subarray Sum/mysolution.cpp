class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        map<int,int> map;
        map[0]=-1;
        int n=nums.size();
        
        int presum=0;
        
        for(int i=0;i<n;i++)
        {
            presum=(presum+nums[i])%k;
            if(map.find(presum)!=map.end())
            {
                if(i-map[presum]>=2)
                    return true;
            }
            else
                map[presum]=i;
        }
        return false;
    }
};