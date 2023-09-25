class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> set1;
        
        for(auto i:nums)
        {
            if(set1.find(i)!=set1.end())
                return true;
            set1.insert(i);
        }
        return false;
    }
};