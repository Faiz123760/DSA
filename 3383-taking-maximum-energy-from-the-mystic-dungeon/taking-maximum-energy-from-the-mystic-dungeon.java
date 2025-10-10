class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;

        // For each modulo group (0, 1, 2, ..., k-1)
        for (int start = n - 1; start >= n - k; start--) {
            int sum = 0;
            // Move backwards in steps of k
            for (int j = start; j >= 0; j -= k) {
                sum += energy[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}
