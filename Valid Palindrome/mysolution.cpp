class Solution {
public:
    bool anumeric(char c)
    {
        return (c>='0'&&c<='9')||(c>='a'&&c<='z');
    }
    
    bool isPalindrome(string s) {
        int n=s.size();
        vector<char> a;
        
        for(char c:s)
        {
            if(c>='A'&&c<='Z')
                a.push_back(c-'A'+'a');
            else
                a.push_back(c);
        }
        
        int i=0, j=n-1;
        
        while(true)
        {
            while(i<n&&!anumeric(a[i]))
                i++;
            
            while(j>=0&&!anumeric(a[j]))
                j--;
            
            if(i>=j)
                return true;
            
            if(a[i]!=a[j])
                return false;
            
            i++;
            j--;
        }
        
        return false;
    }
};