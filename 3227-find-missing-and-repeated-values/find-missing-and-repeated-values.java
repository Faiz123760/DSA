import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        Set<Integer> set = new HashSet<>();
        
        int repeated = -1, missing = -1;
        
        // Flatten the grid and check repeats
        for (int[] row : grid) {
            for (int num : row) {
                if (set.contains(num)) {
                    repeated = num;
                } else {
                    set.add(num);
                }
            }
        }
        
        // Find missing number
        for (int i = 1; i <= total; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        
        return new int[]{repeated, missing};
    }
}
