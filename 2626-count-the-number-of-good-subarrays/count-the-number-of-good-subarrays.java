class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int pairs = 0;
        Map<Integer, Integer> count = new HashMap<>();

        int l = 0;
        for (int r = 0; r < nums.length; ++r) {
            // Increase the number of good subarrays by how many times nums[r] has occurred before
            count.put(nums[r], count.getOrDefault(nums[r], 0));
            pairs += count.get(nums[r]);
            count.put(nums[r], count.get(nums[r]) + 1);

            while (pairs >= k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                pairs -= count.get(nums[l]);
                l++;
            }

            // Add the number of valid starting positions for subarrays ending at r
            ans += l;
        }

        return ans;
    }
}
