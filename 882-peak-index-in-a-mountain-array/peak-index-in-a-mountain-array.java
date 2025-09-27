class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int s=1, e=n-2;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m-1]<arr[m]  && arr[m]>arr[m+1]) return m;
            if(arr[m-1]<arr[m]) s=m+1;
            else e=m-1;
        }
        return -1;
    }
}