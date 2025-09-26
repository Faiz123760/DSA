class Solution {
    public void nextPermutation(int[] nums) {
        //1- find pivot
        int pivot=-1, n=nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            reverse(nums);
            return;
        }

        //2- find rightmost element > pivot
        for(int i=n-1; i>=0; --i){
            if(nums[i]>nums[pivot]){
                 int temp= nums[i];
                 nums[i]= nums[pivot];
                 nums[pivot]= temp;
                 break;
            }
        }

        //3 - reverse (pivot+1) to n-1
        int i=pivot+1, j=n-1;
        while(i<=j){
            int temp= nums[i];
            nums[i]= nums[j];
            nums[j]= temp;
            i++;
            j--;
        }
    }
    void reverse(int nums[]){
        int i=0, j=nums.length-1;
        while(i<=j){
            int temp= nums[i];
            nums[i]= nums[j];
            nums[j]= temp;
            i++;
            j--;
        }
    }
}