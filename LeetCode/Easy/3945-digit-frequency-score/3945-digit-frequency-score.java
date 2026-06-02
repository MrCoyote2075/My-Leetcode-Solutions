class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        String s = String.valueOf(n);

        for(int i = 0 ; i < s.length(); i++) 
            freq[s.charAt(i) - '0']++;

        int ans = 0;
        for(int i = 0 ; i < 10; i++)
            ans += i * freq[i];

        return ans;
    }
}