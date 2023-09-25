class Solution {
public:
    string path(pair<int,int> p1, pair<int,int> p2)
    {
        string ans="";
        
        if(p1.first==5)
        {
            for(int i=p1.first;i>p2.first;i--)
            {
                ans=ans+"U";
            }
            for(int j=p1.second;j<p2.second;j++)
            {
                ans=ans+"R";
            }
        }
        else if(p2.first==5)
        {
            for(int j=p1.second;j>p2.second;j--)
            {
                ans=ans+"L";
            }
            for(int i=p1.first;i<p2.first;i++)
            {
                ans=ans+"D";
            }
        }
        else if(p1.first<=p2.first&&p1.second<=p2.second)
        {
            for(int i=p1.first;i<p2.first;i++)
            {
                ans=ans+"D";
            }
            for(int j=p1.second;j<p2.second;j++)
            {
                ans=ans+"R";
            }
        }
        else if(p1.first<=p2.first&&p1.second>=p2.second)
        {
            for(int i=p1.first;i<p2.first;i++)
            {
                ans=ans+"D";
            }
            for(int j=p1.second;j>p2.second;j--)
            {
                ans=ans+"L";
            }
        }
        else if(p1.first>=p2.first&&p1.second<=p2.second)
        {
            for(int i=p1.first;i>p2.first;i--)
            {
                ans=ans+"U";
            }
            for(int j=p1.second;j<p2.second;j++)
            {
                ans=ans+"R";
            }
        }
        else 
        {
            for(int i=p1.first;i>p2.first;i--)
            {
                ans=ans+"U";
            }
            for(int j=p1.second;j>p2.second;j--)
            {
                ans=ans+"L";
            }
        }
        
        ans=ans+"!";
        return ans;
    }
    
    string alphabetBoardPath(string target) {
        map<char,pair<int,int>> map;
        for(int i=0;i<26;i++)
        {
            map['a'+i]={i/5,i%5};
        }
        
        pair<int,int> prev=map['a'];
        
        string ans="";
        
        for(auto c:target)
        {
            ans=ans+path(prev,map[c]);
            prev=map[c];
        }
        
        return ans;
    }
};