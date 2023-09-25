class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        StringBuilder sb=new StringBuilder();
        
        String str=s.replace("-","");
        
        str=str.toUpperCase();
        
        if(str.equals(""))
            return "";
        
        int end=str.length()-1;
        
        while(end-k+1>=0)
        {
            sb.insert(0,"-"+str.substring(end-k+1,end+1));
            end=end-k;
        }
        
        if(end>=0)
            sb.insert(0,str.substring(0,end+1));
        else
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}