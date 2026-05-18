class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] ans = new int[queries.length];

        int cnt = 0;
        int prev = -1;
        int next = -1;
        
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] prefSum = new int[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') 
                cnt++;
            
            prefSum[i] = cnt;

            if (ch == '|') 
                prev = i;
            
            int ind = n - i - 1;
            if (s.charAt(ind) == '|')
                next = ind;

            pref[i] = prev;
            suff[ind] = next;
        }

        for (int i = 0; i < queries.length; i++) {

            int l = suff[queries[i][0]];
            int r = pref[queries[i][1]];

            if (l == -1 || r == -1 || l >= r)
                continue;

            ans[i] = prefSum[r] - prefSum[l];
        }

        return ans;
    }
}