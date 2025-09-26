class Solution {
    public int trap(int[] height) {
        //calculate leftmax boundary
        int n=height.length;
        int maxL[]= new int[n];
        maxL[0]=height[0];
        for(int i=1;i<n;i++){
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }

        //calculate rightmax boundary
        int maxR[]= new int[n];
        maxR[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            maxR[i] = Math.max(maxR[i+1],height[i]);
        }

        int trapWater=0;
        for(int i=0; i<n;i++){
            int wL= Math.min(maxL[i],maxR[i]);
            trapWater+= wL-height[i];
        }
        return trapWater;
    }
}