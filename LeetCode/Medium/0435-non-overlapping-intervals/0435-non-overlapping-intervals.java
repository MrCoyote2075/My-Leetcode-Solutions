class Solution {
    public int eraseOverlapIntervals(int[][] inter) {
        int n = inter.length;
        Arrays.sort(inter, (a, b) -> a[1] - b[1]);

        int st = inter[0][0], fn = inter[0][1];

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (fn <= inter[i][0]) {
                st = inter[i][0];
                fn = inter[i][1];
            } else 
                ans++;
        }

        return ans;
    }
}