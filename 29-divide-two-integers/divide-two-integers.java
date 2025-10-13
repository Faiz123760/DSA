class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle simple case
        if (dividend == divisor) {
            return 1;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int quotient = 0;

        // Subtract divisor multiples using bit shifting
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            n -= (d << count);
            quotient += (1 << count);
        }

        return negative ? -quotient : quotient;
    }
}
