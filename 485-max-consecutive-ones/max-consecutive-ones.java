class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0, max1=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==1){
                cnt++;
                max1=Math.max(cnt,max1);
            }else cnt=0;
        }
        return max1;
    }
}