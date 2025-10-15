class Solution {
    public int lengthOfLongestSubstring(String str) {
        int s=0, e=0, maxL=0;
        List<Character> list=new ArrayList<>();
        while(e<str.length()){
            if(!list.contains(str.charAt(e))){
                list.add(str.charAt(e));
                e++;
                maxL=Math.max(maxL,list.size());
            }
            else{
                list.remove(Character.valueOf(str.charAt(s)));
                s++;
            }
        }
        return maxL;
    }
}