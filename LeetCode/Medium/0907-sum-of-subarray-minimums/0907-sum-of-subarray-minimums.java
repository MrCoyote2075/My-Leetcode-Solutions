class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1e9 + 7;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int min = (int) 1e9;

            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                ans += min;

                if (MOD <= ans)
                    ans -= MOD;
            }
        }

        return ans;
    }
}