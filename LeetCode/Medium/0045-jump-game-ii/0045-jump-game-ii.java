class Solution {
    public int n;
    public int[] dp;
    public int MAX = (int) 1e9;

    public int rec (int lev, int[] nums) {

        if (lev == n - 1)
            return 0;

        if (dp[lev] != -1)
            return dp[lev];

        int ans = MAX;

        for (int i = 1; i <= nums[lev] ; i++)
            if (lev + i < n)
                ans = Math.min(ans, rec (lev + i, nums) + 1);

        return dp[lev] = ans;
    }

    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];

        Arrays.fill(dp, -1);

        return rec(0, nums);
    }
}