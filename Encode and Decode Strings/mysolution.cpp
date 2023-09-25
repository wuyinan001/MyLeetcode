class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string ans="";
        
        for(auto s:strs)
        {
            int n=s.size();
            string len=to_string(n);
            
            for(int i=1;i<=4-len.size();i++)
            {
                ans=ans+"0";
            }
            
            ans=ans+len;
            ans=ans+s;
        }
        
        return ans;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        int curr=0;
        vector<string> ans;
        int n=s.size();
        
        while(curr<n)
        {
            int len=stoi(s.substr(curr,4));
            curr+=4;
            ans.push_back(s.substr(curr,len));
            curr+=len;
        }
        
        return ans;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));