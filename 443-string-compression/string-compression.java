class Solution {
    public int compress(char[] chars) {
           int n=chars.length;
           int idx=0, i=0;
           while(i<n)   {
            char currChar= chars[i];
            int j=i;
            while(j<n && chars[j]==currChar)j++;
            chars[idx++] = currChar;
            int count=j-i;
            if(count>1){
                String countStr = Integer.toString(count);
                for(char c:countStr.toCharArray())
                      chars[idx++]= c;
            }
            i=j;
           }
           return idx;
    }
}