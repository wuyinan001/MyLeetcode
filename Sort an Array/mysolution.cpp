class Solution {
public:
    void exchange(vector<int>& nums, int i, int j)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    void sort(vector<int>& nums, int lo, int hi)
    {
        if(lo>=hi)
            return;
        
        int v=nums[lo];
        int lt=lo, ht=hi, i=lo+1;
        
        while(i<=ht)
        {
            if(nums[i]<v)
                exchange(nums,lt++,i++);
            else if(nums[i]>v)
                exchange(nums,ht--,i);
            else
                i++;
        }
        
        sort(nums,lo,lt-1);
        sort(nums,ht+1,hi);
    }
    
    vector<int> sortArray(vector<int>& nums) {
        int n=nums.size();
        
        sort(nums,0,n-1);
        return nums;
    }
};