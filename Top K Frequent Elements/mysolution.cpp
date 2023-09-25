class Compare
{
public:
    bool operator()(pair<int,int> a, pair<int,int> b)
    {
        return a.second>b.second;
    }
};

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int,int> freq;
        
        for(auto i:nums)
        {
            freq[i]++;
        }
        
        vector<int> ans;
        
        priority_queue<pair<int,int>,vector<pair<int,int>>, Compare> pq;
        
        for(auto i:freq)
        {
            pq.push({i.first,i.second});
            if(pq.size()>k)
                pq.pop();
        }
        
        while(!pq.empty())
        {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        
        return ans;
    }
};