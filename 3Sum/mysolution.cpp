class Solution {
public:
    void twoSum(vector<int>& nums, int index, vector<vector<int>>& list)
    {
        set<int> set;
        for(int i=index+1;i<nums.size();i++)
        {
            if(set.find(-nums[i]-nums[index])!=set.end())
            {
                vector<int> tmp{nums[index],-nums[i]-nums[index],nums[i]};
                list.push_back(tmp);
                while((i<nums.size()-1)&&(nums[i]==nums[i+1]))
                    i++;
            }
            set.insert(nums[i]);
        }
    }
    
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>0)
                break;
            
            if(i>0 and nums[i]==nums[i-1])
                continue;
            
            twoSum(nums,i,ans);
        }
        
        return ans;
    }
};