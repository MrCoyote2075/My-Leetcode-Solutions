class Solution {
    public final int MAX = (int) 1e9;
    public int minSubArrayLen(int target, int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        int ans = MAX;

        for (int i = 0, j = 0 ; j < n ; j++) {
            sum += nums[j];

            while (target <= sum) {
                ans = Math.min(j - i + 1, ans);
                sum -= nums[i++];
            }
        }

        return ans == MAX ? 0 : ans;
    }
}