class Solution {
public:
    bool isValid(string s) {
        vector<char> stack;
        
        for(char c:s)
        {
            if(c==')')
            {
                if(stack.size()>0 && stack.back()=='(')
                    stack.pop_back();
                else
                    return false;
            }
            else if(c==']')
            {
                if(stack.size()>0 && stack.back()=='[')
                    stack.pop_back();
                else
                    return false;
            }
            else if(c=='}')
            {
                if(stack.size()>0 && stack.back()=='{')
                    stack.pop_back();
                else
                    return false;
            }
            else
                stack.push_back(c);
        }
        
        return stack.size()==0;
    }
};