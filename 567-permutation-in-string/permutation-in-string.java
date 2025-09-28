class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i=0;i<s1.length();i++)
             freq[s1.charAt(i)-97]++;
            
        int windSize= s1.length();
        for(int i=0;i<s2.length();i++){
            int windIdx=0, idx=i;
            int windFreq[]= new int[26];
            while(windIdx<windSize && idx<s2.length()){
                windFreq[s2.charAt(idx)-97]++;
                windIdx++;
                idx++;
            }
            if(isFreqSame(freq,windFreq)) return true;
        }
        return false;
    }
    boolean isFreqSame(int freq1[], int freq2[]){
        for(int i=0;i<26;i++)
            if(freq1[i]!=freq2[i]) return false;
        return true;
    }
}