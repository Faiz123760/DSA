class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;
        
        // Count zeros
        for (int num : arr) {
            if (num == 0) zeros++;
        }
        
        int i = n - 1;         // original index
        int j = n + zeros - 1; // virtual index if we had extra space
        
        // Traverse backwards
        while (i < j) {
            if (arr[i] != 0) {
                if (j < n) arr[j] = arr[i];
            } else {
                if (j < n) arr[j] = 0;
                j--;
                if (j < n) arr[j] = 0;
            }
            i--;
            j--;
        }
    }
}
