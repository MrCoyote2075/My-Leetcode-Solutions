class Solution {
    public int n;
    public int[][] dp;
    public int rec(int lev, int prev, int[] nums) {

        if (lev == n)
            return 0;

        if (dp[lev][prev + 1] != -1)
            return dp[lev][prev + 1];

        int ans = 0;

        for (int i = lev; i < n; i++) {
            if (prev == -1 || nums[prev] < nums[i])
                ans = Math.max(ans, rec(i + 1 , i, nums) + 1);
        }

        return dp[lev][prev + 1] = ans;
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 2][n + 2];

        for (int[] row : dp) 
            Arrays.fill(row, -1);

        return rec(0, -1, nums);
    }
}