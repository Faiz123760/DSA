class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int s=0, e=n-1;
        int missing=compute(arr[n-1],n);
        while(s<=e){
            int m=s+(e-s)/2;
            missing=compute(arr[m],m+1);
            if(missing>=k) e=m-1;
            else s=m+1;
        }
        if(e==-1) return k;
        return arr[e]+k-compute(arr[e],e+1);
    }
    int compute(int actual, int expected){
        return actual-expected;
    }
}