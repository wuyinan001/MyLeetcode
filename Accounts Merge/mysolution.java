class Solution {
    
    private class Account
    {
        String name;
        Set<String> set;
        
        public Account(List<String> list)
        {
            name=list.get(0);
            
            set=new HashSet();
            
            for(int i=1;i<list.size();i++)
            {
                set.add(list.get(i));
            }
        }
    }
    
    private boolean hasCommon(Account a1, Account a2)
    {
        if(a1.set.size()<a2.set.size())
        {
            for(String s:a1.set)
            {
                if(a2.set.contains(s))
                    return true;
            }
        }
        else
        {
            for(String s:a2.set)
            {
                if(a1.set.contains(s))
                    return true;
            }
        }
        
        return false;
    }
    
    private Account merge(Account a1, Account a2)
    {
        for(String s:a2.set)
            if(!a1.set.contains(s))
                a1.set.add(s);
        
        return a1;
    }
    
    private List<Account> mergeList(List<Account> list)
    {
        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                if(hasCommon(list.get(i),list.get(j)))
                {
                    Account newAccount=merge(list.get(i),list.get(j));
                    list.remove(i);
                    list.remove(j-1);
                    list.add(newAccount);
                    
                    return mergeList(list);
                }
            }
        }
        
        return list;
    }
    
    private List<List<String>> toList(List<Account> list)
    {
        List<List<String>> ans=new ArrayList();
        
        for(Account a:list)
        {
            List<String> temp=new ArrayList();
            
            for(String s:a.set)
                temp.add(s);
            
            Collections.sort(temp);
            
            temp.add(0,a.name);
            
            ans.add(temp);
        }
        
        return ans;
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<Account> list=new ArrayList();
        
        for(List<String> account:accounts)
            list.add(new Account(account));
        
        List<Account> ans=mergeList(list);
        
        return toList(ans);
        
    }
}