class Solution {
    public int search(int[] nums, int tar) {
        int s=0, e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(tar==nums[m]) return m;
            if(nums[s]<=nums[m]){  //left sorted
                if(nums[s]<=tar && tar<=nums[m]) e=m-1;
                else s=m+1;
            }
            else{   //right sorted
                if(nums[m]<=tar && tar<=nums[e]) s=m+1;
                else e=m-1;
            }
        }
        return -1;
    }
}