class Compare1
{
public:
    vector<int> arr;
    
    Compare1(vector<int>& arr)
    {
        this->arr=arr;
    }
    
    bool operator()(int i, int j)
    {
        if(arr[i]==arr[j])
            return i<j;
        return arr[i]<arr[j];
    }
};

class Compare2
{
public:
    vector<int> arr;
    
    Compare2(vector<int>& arr)
    {
        this->arr=arr;
    }
    
    bool operator()(int i, int j)
    {
        if(arr[i]==arr[j])
            return i<j;
        return arr[i]>arr[j];
    }
};

class Solution {
public:
    void print(vector<int>& v)
    {
        for(auto i:v)
            cout<<i<<" ";
        cout<<endl;
    }
    
    vector<int> findNextOdd(vector<int>& arr)
    {
        int n=arr.size();
        vector<int> ans(n,-1);
        vector<int> index;
        
        for(int i=0;i<n;i++)
            index.push_back(i);
        
        sort(index.begin(),index.end(),Compare1(arr));
        
        vector<int> stack;
        
        for(auto i:index)
        {
            while(!stack.empty()&&i>stack.back())
            {
                ans[stack.back()]=i;
                stack.pop_back();
            }
            stack.push_back(i);
        }
        
        return ans;
    }
    
    vector<int> findNextEven(vector<int>& arr)
    {
        int n=arr.size();
        vector<int> ans(n,-1);
        vector<int> index;
        
        for(int i=0;i<n;i++)
            index.push_back(i);
        
        sort(index.begin(),index.end(),Compare2(arr));
        
        vector<int> stack;
        
        for(auto i:index)
        {
            while(!stack.empty()&&i>stack.back())
            {
                ans[stack.back()]=i;
                stack.pop_back();
            }
            stack.push_back(i);
        }
        
        return ans;
    }
    
    int oddEvenJumps(vector<int>& arr) {
        int n=arr.size();
        vector<int> nextOdd=findNextOdd(arr);
        vector<int> nextEven=findNextEven(arr);
        
        // print(nextOdd);
        // print(nextEven);
        
        vector<bool> odd(n,false);
        vector<bool> even(n,false);
        
        odd[n-1]=true;
        even[n-1]=true;
        int ans=1;
        
        for(int i=n-2;i>=0;i--)
        {
            if(nextEven[i]!=-1&&odd[nextEven[i]])
                even[i]=true;
            if(nextOdd[i]!=-1&&even[nextOdd[i]])
            {
                odd[i]=true;
                ans++;
            }
        }
        
        return ans;
    }
};