class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9 + 7;
        long ans = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        // previous less element
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                count += left[st1.pop()];
            }
            left[i] = count;
            st1.push(i);
        }

        // next less or equal element
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                count += right[st2.pop()];
            }
            right[i] = count;
            st2.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans = (ans + (long)arr[i] * left[i] * right[i]) % MOD;
        }

        return (int)ans;
    }
}
