class Solution {
public:
    string convert(string s)
    {
        vector<char> array;
        for(char c:s)
        {
            array.push_back(c);
        }
        
        sort(array.begin(),array.end());
        
        return string(array.begin(),array.end());
    }
    
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        vector<vector<string>> ans;
        map<string,vector<string>> map;
        
        for(string s:strs)
        {
            string s_sort=convert(s);
            map[s_sort].push_back(s);
        }
        
        for(auto i:map)
        {
            ans.push_back(i.second);
        }
        
        return ans;
    }
};