class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int counter=0;
        for(char c:s.toCharArray()){
            if(c==')') counter--;
            
            if(counter!=0) sb.append(c);
            if(c=='(') counter++;
            
        }
        return sb.toString();
    }
}