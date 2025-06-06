class Solution {
    private static final int MOD = 1_000_000_007;

    public int idealArrays(int n, int maxValue) {
        int maxLength = Math.min(14, n);
        List<List<Integer>> factors = getFactors(maxValue);
        long[][] dp = new long[maxLength + 1][maxValue + 1];
        Long[][] mem = new Long[n][maxLength];

        // Initialize dp for length 1
        for (int j = 1; j <= maxValue; ++j) {
            dp[1][j] = 1;
        }

        // Build dp table
        for (int i = 2; i <= maxLength; ++i) {
            for (int j = 1; j <= maxValue; ++j) {
                for (int k : factors.get(j)) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        // Compute dp[i][0] as the sum of all dp[i][j]
        for (int i = 1; i <= maxLength; ++i) {
            for (int j = 1; j <= maxValue; ++j) {
                dp[i][0] += dp[i][j];
                dp[i][0] %= MOD;
            }
        }

        long ans = 0;
        for (int i = 1; i <= maxLength; ++i) {
            long ways = dp[i][0] * nCk(n - 1, i - 1, mem) % MOD;
            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }

    private List<List<Integer>> getFactors(int maxValue) {
        List<List<Integer>> factors = new ArrayList<>();
        for (int i = 0; i <= maxValue; ++i) {
            factors.add(new ArrayList<>());
        }

        for (int i = 1; i <= maxValue; ++i) {
            for (int j = i * 2; j <= maxValue; j += i) {
                factors.get(j).add(i);
            }
        }

        return factors;
    }

    private long nCk(int n, int k, Long[][] mem) {
        if (k == 0 || n == k) return 1;
        if (mem[n][k] != null) return mem[n][k];
        return mem[n][k] = (nCk(n - 1, k, mem) + nCk(n - 1, k - 1, mem)) % MOD;
    }
}
