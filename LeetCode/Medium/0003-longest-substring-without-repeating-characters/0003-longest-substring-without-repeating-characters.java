class Solution {
    // public final int MIN = (int) -1e9;

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] vis = new boolean[256];

        int ans = 0;
        for (int i = 0, j = 0 ; j < n ; j++) {
            int ind = s.charAt(j);

            while (vis[ind]) {
                vis[s.charAt(i)] = false;
                i++;
            }

            vis[ind] = true;
            ans = Math.max(j - i + 1, ans);
        }

        return ans;
    }
}