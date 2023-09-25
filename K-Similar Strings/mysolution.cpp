class Solution {
public:
    int ans=INT_MAX;
    
    void swap(vector<char>& l, int i, int j)
    {
        char t=l[i];
        l[i]=l[j];
        l[j]=t;
    }
    
    void backTrack(vector<char>& l1, vector<char>& l2, int index, int curr)
    {
        if(index==l1.size())
        {
            ans=min(ans,curr);
            return;
        }
        
        if(l1[index]==l2[index])
            backTrack(l1,l2,index+1,curr);
        else
        {
            for(int i=index+1;i<l1.size();i++)
            {
                if(l1[i]==l2[index]&&l1[i]!=l2[i])
                {
                    swap(l1,index,i);
                    backTrack(l1,l2,index+1,curr+1);
                    swap(l1,index,i);
                }
            }
        }
        
    }
    
    int kSimilarity(string s1, string s2) {
        vector<char> v1;
        vector<char> v2;
        int n=s1.size();
        
        for(int i=0;i<n;i++)
        {
            v1.push_back(s1.at(i));
            v2.push_back(s2.at(i));
        }
        
        backTrack(v1,v2,0,0);
        return ans;
    }
};