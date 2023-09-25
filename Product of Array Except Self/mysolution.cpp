class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n=nums.size();
        vector<int> L(n,0);
        vector<int> R(n,0);
        
        L[0]=nums[0];
        R[n-1]=nums[n-1];
        
        for(int i=1;i<n;i++)
            L[i]=L[i-1]*nums[i];
        
        for(int i=n-2;i>=0;i--)
            R[i]=R[i+1]*nums[i];
        
        vector<int> ans(n,0);
        
        for(int i=1;i<n-1;i++)
            ans[i]=L[i-1]*R[i+1];
        
        ans[0]=R[1];
        ans[n-1]=L[n-2];
        
        return ans;
    }
};