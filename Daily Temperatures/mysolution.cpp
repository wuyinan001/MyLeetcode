class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n=temperatures.size();
        vector<int> stack{n-1};
        vector<int> ans(n,0);
        
        for(int i=n-2;i>=0;i--)
        {
            while(!stack.empty()&&temperatures[i]>=temperatures[stack.back()])
            {
                stack.pop_back();
            }
            
            if(!stack.empty())
                ans[i]=stack.back()-i;
            
            stack.push_back(i);
        }
        
        return ans;
    }
};