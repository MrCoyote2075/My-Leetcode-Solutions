class Solution {

    public int maxDistance(String moves) {
        int n = moves.length();

        char[][] dir = {
            {'U', 'R'},
            {'U', 'L'},
            {'D', 'R'},
            {'D', 'L'}
        };

        int ans = 0;
        for (char[] pos : dir) {
            int cnt = 0;
            for (int i = 0 ; i < n ; i ++) {
                char ch = moves.charAt(i);

                if (ch == pos[0] || ch == pos[1] || ch == '_')
                    cnt++;
                else
                    cnt--;
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}