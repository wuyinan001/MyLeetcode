class Solution {
    
    String[] code={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> set=new HashSet();
        
        for(String word:words)
        {
            StringBuilder output=new StringBuilder();
            
            int n=word.length();
            
            for(int i=0;i<n;i++)
            {
                output.append(code[word.charAt(i)-'a']);
            }
            
            set.add(output.toString());
        }
        
        return set.size();
        
    }
}