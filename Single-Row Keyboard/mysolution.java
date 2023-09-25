class Solution {
    public int calculateTime(String keyboard, String word) {
        
        Map<Character,Integer> map=new HashMap();
        
        for(int i=0;i<keyboard.length();i++)
            map.put(keyboard.charAt(i),i);
        
        int sum=0;
        
        int curr=0;
        
        for(int i=0;i<word.length();i++)
        {
            int des=map.get(word.charAt(i));
            
            sum+=Math.abs(des-curr);
            
            curr=des;
        }
        
        return sum;
        
    }
}