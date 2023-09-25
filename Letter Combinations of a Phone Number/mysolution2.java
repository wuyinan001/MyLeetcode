class Solution {
    
    private List<String> backTrack(String s, List<String> list)
    {
        if(s.equals(""))
            return list;
        
        char c=s.charAt(0);
        
        if(c=='2')
        {
            
            if(list.isEmpty())
            {
                list.add("a");
                list.add("b");
                list.add("c");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"a");
                    temp.add(str+"b");
                    temp.add(str+"c");
                }
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='3')
        {
            
            if(list.isEmpty())
            {
                list.add("d");
                list.add("e");
                list.add("f");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"d");
                    temp.add(str+"e");
                    temp.add(str+"f");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='4')
        {
            
            if(list.isEmpty())
            {
                list.add("g");
                list.add("h");
                list.add("i");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"g");
                    temp.add(str+"h");
                    temp.add(str+"i");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='5')
        {
            
            if(list.isEmpty())
            {
                list.add("j");
                list.add("k");
                list.add("l");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"j");
                    temp.add(str+"k");
                    temp.add(str+"l");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='6')
        {
            
            if(list.isEmpty())
            {
                list.add("m");
                list.add("n");
                list.add("o");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"m");
                    temp.add(str+"n");
                    temp.add(str+"o");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='7')
        {
            
            if(list.isEmpty())
            {
                list.add("p");
                list.add("q");
                list.add("r");
                list.add("s");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"p");
                    temp.add(str+"q");
                    temp.add(str+"r");
                    temp.add(str+"s");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else if(c=='8')
        {
            
            if(list.isEmpty())
            {
                list.add("t");
                list.add("u");
                list.add("v");
                
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"t");
                    temp.add(str+"u");
                    temp.add(str+"v");
                    
                }
                
                
                list=new ArrayList(temp);
            }
        }
        else 
        {
            
            if(list.isEmpty())
            {
                list.add("w");
                list.add("x");
                list.add("y");
                list.add("z");
            }
            else
            {
                List<String> temp=new ArrayList();
                
                for(String str:list)
                {
                    temp.add(str+"w");
                    temp.add(str+"x");
                    temp.add(str+"y");
                    temp.add(str+"z");
                }
                
                
                list=new ArrayList(temp);
            }
        }
        
        
        
        return backTrack(s.substring(1),list);
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> ans=new ArrayList();
        
        ans=backTrack(digits, ans);
        
        return ans;
    }
}