class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n=nums.size();
        
        int presum=0;
        map<int,int> map;
        map[0]=-1;
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
                presum+=-1;
            else
                presum+=1;
            
            if(map.find(presum)!=map.end())
            {
                ans=max(ans,i-map[presum]);
            }
            else
                map[presum]=i;
        }
        
        return ans;
    }
};