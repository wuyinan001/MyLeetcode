public class Codec {

    // Convert a number 0-9999 to a 4-digit string. For example, 235->"0235"
    private String convertFourDigit(int n)
    {
        String str=Integer.toString(n);
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        
        while(sb.length()<4)
        {
           sb.append(0);
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        if(strs.isEmpty())
            return "";
        
        StringBuilder sb=new StringBuilder();
        
        for(String s:strs)
        {
            int len=s.length();
            String size_str=convertFourDigit(len);
            
            sb.append(size_str);
            sb.append(s);
        }
        
        //System.out.println(sb.toString());
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> ans=new ArrayList<>();
        
        for(int i=0;i<s.length();)
        {
            int len=Integer.parseInt(s.substring(i,i+4));
            i=i+4;
            ans.add(s.substring(i,i+len));
            i=i+len;
        }
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));