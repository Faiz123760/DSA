class Solution {
    public int largestRectangleArea(int[] ht) {
        int n=ht.length;
        //right smaller nearest
        Stack<Integer> s= new Stack<>();
        int right[]= new int[n];
        for(int i=n-1; i>=0;i--){
            while(!s.isEmpty() &&  ht[s.peek()]>=ht[i]) s.pop();
            right[i] = s.isEmpty() ? n:s.peek();
            s.push(i);
        }


        //left smaller nearest
        Stack<Integer> st= new Stack<>();
        int left[]= new int[n];
        for(int i=0; i<n;i++){
            while(!st.isEmpty() &&  ht[st.peek()]>=ht[i]) st.pop();
            left[i] = st.isEmpty() ? -1:st.peek();
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int currArea= ht[i]*(right[i]-left[i]-1);
            maxArea= Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}