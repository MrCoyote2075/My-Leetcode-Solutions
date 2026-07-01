class Solution {
    public Map<Integer, Integer> freq = new HashMap<>();
    public ArrayList<ArrayList<Integer>> grp = new ArrayList<>();

    public long rec(int u, int mask, String s) {
        long ans = 0;

        for (int bit = 1 << 25; 0 < bit; bit >>= 1)
            ans += freq.getOrDefault(mask ^ bit, 0);

        ans += freq.getOrDefault(mask, 0);

        freq.merge(mask, 1, Integer::sum);

        for (int v : grp.get(u))
            ans += rec(v, mask ^ (1 << (s.charAt(v) - 'a')), s);

        return ans;
    }

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();

        for (int i = 0; i < n; i++)
            grp.add(new ArrayList<>());

        for (int i = 1; i < n; i++)
            grp.get(parent.get(i)).add(i);

        return rec(0, 0, s);
    }
}