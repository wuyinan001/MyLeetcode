/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    
    int length=-1;
    
    private boolean sameHost(String s1, String s2, int n)
    {
        
        
        return s1.substring(7,Math.min(7+n,s1.length())).equals(s2.substring(7,Math.min(7+n,s2.length())));
    }
    
    Set<String> set=new HashSet();
    
    private void dfs(String s, HtmlParser parser)
    {
        set.add(s);
        
        List<String> localList=parser.getUrls(s);
        
        if(!localList.isEmpty())
        {
            for(String str:localList)
            {
                if(!set.contains(str)&&sameHost(s,str,length))
                    dfs(str,parser);
            }
        }
    }
    
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        String s1=startUrl.substring(7);
        int b=-1;
        
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)=='/')
            {
                b=i;
                break;
            }
        
        if(b==-1)
            length=s1.length();
        else
            length=b;
        
        dfs(startUrl,htmlParser);
        
        List<String> ans=new ArrayList();
        
        for(String s:set)
                ans.add(s);
        
        return ans;
    }
}