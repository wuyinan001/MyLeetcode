class Solution {
    
    Map<Integer,String> map=new HashMap();
    
    private void setMap()
    {
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(0,"Zero");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(10,"Ten");
    }
    
    // Convert a num from 1~999 to a string
    private String convert(int num)
    {
        if(num==0)
            return "";
            
        StringBuilder sb=new StringBuilder();
        int h=num/100;
        
        if(h!=0)
            sb.append(map.get(h)+" Hundred ");
        
        num=num%100;
        
        if(num==0)
        {
            sb.deleteCharAt(sb.length()-1);
        }
        else if(num<20)
            sb.append(map.get(num));
        else
        {
            int b=num/10;
            num=num%10;
            
            switch(b)
            {
                case 2:
                    sb.append("Twenty");
                    break;
                case 3:
                    sb.append("Thirty");
                    break;
                case 4:
                    sb.append("Forty");
                    break;
                case 5:
                    sb.append("Fifty");
                    break;
                case 6:
                    sb.append("Sixty");
                    break;
                case 7:
                    sb.append("Seventy");
                    break;
                case 8:
                    sb.append("Eighty");
                    break;
                case 9:
                    sb.append("Ninety");
                    break;
                default:
                    break;
            }
            
            if(num!=0)
                sb.append(" "+map.get(num));
        }
        
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        
        if(num==0)
            return "Zero";
        
        setMap();
        
        int b=num/1000000000;
        num=num%1000000000;
        int m=num/1000000;
        num=num%1000000;
        int t=num/1000;
        num=num%1000;
        
        StringBuilder sb=new StringBuilder();
        
        if(b!=0)
            sb.append(convert(b)+" Billion ");
        
        if(m!=0)
            sb.append(convert(m)+" Million ");
        
        if(t!=0)
            sb.append(convert(t)+" Thousand ");
        
        sb.append(convert(num));
        
        if(sb.charAt(sb.length()-1)==' ')
            sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}