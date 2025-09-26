class Solution {
    boolean searchInRow(int mat[][],int target, int row){
        int n=mat[0].length;
        int s=0, e=n-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==mat[row][m]) return true;
            else if(target> mat[row][m]) s=m+1;
            else e=m-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length, n=mat[0].length;
        int s=0, e=m-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target>= mat[mid][0] && target<=mat[mid][n-1])
                return searchInRow(mat,target,mid);
            else if(target>=mat[mid][n-1]) s=mid+1;
            else e=mid-1;
        }
        return false;
    }
}