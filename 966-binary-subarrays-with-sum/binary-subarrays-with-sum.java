class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    int helper(int nums[],int goal){
        if(goal<0) return 0;
        int count=0, sum=0, s=0, e=0;
        while(s<nums.length){
            sum+=nums[s];
            while(e<nums.length && sum>goal){
                sum-=nums[e];
                e++;
            }
            count+=s-e+1;
            s++;
        }
        return count;
    }
}