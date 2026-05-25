class Solution {
    public int n;
    public int[] dp;

    public int rec(int i, int[] nums) {
        if (i == n)
            return 0;
        
        if (dp[i] != -1)
            return dp[i];

        int ans = 0;
        for (int j = i + 1; j < n; j++)
            if (nums[i] < nums[j])
                ans = Math.max(ans, rec(j, nums) + 1);
        
        return dp[i] = ans;
    }
    
    public int lengthOfLIS(int[] nums) {
        n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;
        for (int i = 0 ; i < n ; i++)
            ans = Math.max(ans, rec(i, nums) + 1);

        return ans;
    }
}