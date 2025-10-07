class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int val:asteroids){
            if(s.size()==0 || val>0)
                s.push(val);
            else{
                while(s.size()>0 && s.peek()>0 && s.peek()<-val)
                    s.pop();
                if(s.size()>0 && s.peek()==-val)
                    s.pop();
                else if(s.size()==0 || s.peek()<0)
                    s.push(val);
            }
        }
        int ans[]=new int[s.size()];
        int i=ans.length-1;
        while(i>=0)
            ans[i--]=s.pop();
        
        return ans;
    }
}