class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m=new HashMap<>();
        Stack<Integer> s=new Stack<>();

        for(int n:nums2){
            while(!s.isEmpty() && n>s.peek()) m.put(s.pop(),n);
            s.push(n);
        }

        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++) 
            res[i]=m.getOrDefault(nums1[i],-1);
        return res;
    }
}