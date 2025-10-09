class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";
        StringBuilder s=new StringBuilder();
        for(char c:num.toCharArray()){
            while(s.length()>0 && k>0 && s.charAt(s.length()-1)>c){
                s.deleteCharAt(s.length()-1);
                k--;
            }
            s.append(c);
        }

        while(k>0 && s.length()>0){
            s.deleteCharAt(s.length()-1);
            k--;
        }

        int i=0;
        while(i<s.length() && s.charAt(i)=='0') i++;
        String res= (i==s.length())?"0":s.substring(i);
        return res;
    }
}