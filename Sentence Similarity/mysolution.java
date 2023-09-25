class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length!=sentence2.length)
            return false;
        
        int n=sentence1.length;
        
        Set<List<String>> set=new HashSet();
        
        for(List<String> list:similarPairs)
            set.add(list);
        
        for(int i=0;i<n;i++)
        {
            if(sentence1[i].equals(sentence2[i]))
                continue;
            
            List<String> list1=new ArrayList();
            list1.add(sentence1[i]);
            list1.add(sentence2[i]);
            
            List<String> list2=new ArrayList();
            list2.add(sentence2[i]);
            list2.add(sentence1[i]);
            
            if(!set.contains(list1)&&!set.contains(list2))
                return false;
        }

        return true;
    }
}