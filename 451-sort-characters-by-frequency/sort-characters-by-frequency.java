class Solution {
    public String frequencySort(String s) {
        StringBuilder ans=new StringBuilder();
        Map<Character,Integer> m=new HashMap<>();

        for(char c:s.toCharArray())
            m.put(c, m.getOrDefault(c,0)+1);
        
        List<Character> list=new ArrayList(m.keySet());
        list.sort((o1,o2)->m.get(o2)-m.get(o1));

        for(char c:list){
            for(int i=0;i<m.get(c);i++)
                ans.append(c);
        }
        return ans.toString();
    }
}