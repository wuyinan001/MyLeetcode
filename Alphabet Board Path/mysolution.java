class Solution {
    public String alphabetBoardPath(String target) {
        
        Map<Character,int[]> map=new HashMap();
        
        for(int i=0;i<26;i++)
        {
            char c=(char)('a'+i);
            map.put(c,new int[]{i/5,i%5});
        }
        
        int[] curr={0,0};
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<target.length();i++)
        {
            char c=target.charAt(i);
            
            int[] des=map.get(c);
            
            // If curr position is at curr[1]>0 and next destination is 'z'
            
            if(c=='z'&&curr[1]>0)
            {
                while(curr[1]>0)
                {
                    sb.append("L");
                    curr[1]--;
                }
            }
            
            while(curr[0]!=des[0]||curr[1]!=des[1])
            {
                while(curr[0]<des[0])
                {
                    sb.append("D");
                    curr[0]++;
                }
                
                while(curr[0]>des[0])
                {
                    sb.append("U");
                    curr[0]--;
                }
                
                while(curr[1]<des[1])
                {
                    sb.append("R");
                    curr[1]++;
                }
                
                while(curr[1]>des[1])
                {
                    sb.append("L");
                    curr[1]--;
                }
            }
            
            sb.append("!");
        }
        
        return sb.toString();
    }
}