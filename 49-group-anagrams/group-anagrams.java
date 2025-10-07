class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> m=new HashMap<>();
        for(String s:strs){
            int []count=new int[26];
            for(char c:s.toCharArray())
                 count[c-97]++;
            StringBuilder sb=new StringBuilder();
            for(int i:count){
                sb.append("#");
                sb.append(i);
            }

            String key=sb.toString();
            if(!m.containsKey(key))
                m.put(key,new ArrayList<String>());
            m.get(key).add(s);
        }
        return new ArrayList(m.values());
    }
}