class Solution {
    public List<String> letterCasePermutation(String S) {
        
        List<String> ans=new ArrayList<>();
        
        backTrack(ans,S,0);
        
        return ans;
    }
    
    private void backTrack(List<String> ans, String S, int index)
    {
        if(index>=S.length())
            return;
        
        if(index==0)
        {
            char c=S.charAt(index);
            
            if(c>='a'&&c<='z')
            {
                ans.add(""+c);
                ans.add(""+(char)(c-'a'+'A'));
            }
            else if(c>='A'&&c<='Z')
            {
                ans.add(""+c);
                ans.add(""+(char)(c-'A'+'a'));
            }
            else
                ans.add(""+c);
            
            backTrack(ans,S,1);
            return;
        }
        
        if(S.charAt(index)>='a'&&S.charAt(index)<='z')
        {
            int length=ans.size();
            
            for(int i=0;i<length;i++)
            {
                ans.add(ans.get(i)+S.charAt(index));
            }
            
            for(int i=0;i<length;i++)
            {
                char temp=(char)(S.charAt(index)-'a'+'A');
                ans.set(i,ans.get(i)+temp);
            }
        }
        else if(S.charAt(index)>='A'&&S.charAt(index)<='Z')
        {
            int length=ans.size();
            
            for(int i=0;i<length;i++)
            {
                ans.add(ans.get(i)+S.charAt(index));
            }
            
            for(int i=0;i<length;i++)
            {
                char temp=(char)(S.charAt(index)-'A'+'a');
                ans.set(i,ans.get(i)+temp);
            }
        }
        else
        {
            int length=ans.size();
            
            for(int i=0;i<length;i++)
            {
                ans.set(i,ans.get(i)+S.charAt(index));
            }
        }
        
        index++;
        backTrack(ans,S,index);
    }
    

}