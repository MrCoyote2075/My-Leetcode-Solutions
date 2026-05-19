class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] pref = new int[n + 1];

        int xor = 0;
        for (int i = 0 ; i < n ; i++) {
            int ind = s.charAt(i) - 'a';
            int val = (1 << ind);

            xor ^= val;
            pref[i + 1] = xor;
        }

        ArrayList<Boolean> ans = new ArrayList<>();
        for (int[] qu : queries) {
            int l = qu[0];
            int r = qu[1];
            int k = qu[2];

            int val = pref[l] ^ pref[r + 1];
            int bitCount = Integer.bitCount(val);

            if ((bitCount & 1) == 1) 
                ans.add(((bitCount - 1) / 2) <= k);
            else 
                ans.add((bitCount / 2) <= k);
            
        }

        return ans;
    }
}