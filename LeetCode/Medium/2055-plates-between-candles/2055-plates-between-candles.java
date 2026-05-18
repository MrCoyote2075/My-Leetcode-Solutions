class Solution {
    public int lowerBound(int x, ArrayList<Integer> arr) {
        int l = 0, r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (x <= arr.get(mid)) {
                ans = mid;
                r = mid - 1;

            } else
                l = mid + 1;
        }

        return ans;
    }

    public int upperBound(int x, ArrayList<Integer> arr) {
        int l = 0, r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) <= x) {
                ans = mid;
                l = mid + 1;

            } else
                r = mid - 1;
        }

        return ans;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        ArrayList<Integer> arr = new ArrayList<>();

        int[] ans = new int[queries.length];

        int[] pref = new int[s.length()];

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|')
                arr.add(i);
            else
                cnt++;

            pref[i] = cnt;
        }

        // System.out.println(Arrays.toString(pref));

        for (int i = 0; i < queries.length; i++) {

            int l = lowerBound(queries[i][0], arr);
            int r = upperBound(queries[i][1], arr);

            if (l == -1 || r == -1 || l == r || l > r)
                continue;

            // System.out.println(arr.get(l) + ":" + arr.get(r));
            ans[i] = pref[arr.get(r)] - pref[arr.get(l)];
        }

        return ans;
    }
}