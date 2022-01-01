class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoinsHelper(nums, 0, nums.length - 1, dp);
    }
    public int maxCoinsHelper(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int max = 0;
        for (int i = start; i <= end; i++) {
            int val = maxCoinsHelper(nums, start, i - 1, dp) + 
                maxCoinsHelper(nums, i + 1, end, dp) + 
                getVal(nums, start - 1) * getVal(nums, i) * getVal(nums, end + 1);
            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
    }
    private int getVal(int[] nums, int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        }
        return nums[i];
    }
}
