class Solution {
    public int longestOnes(int[] nums, int k) {
        int s=0, maxOnes=0, zeroCount=0;
        for(int e=0;e<nums.length;e++){
            if(nums[e]==0) zeroCount++;
            while(zeroCount>k){
                if(nums[s]==0) zeroCount--;
                s++;
            }
            maxOnes=Math.max(maxOnes,e-s+1);
        }
        return maxOnes;
    }
}