class Solution {
    public String[] createGrid(int m, int n) {
        String[] mat = new String[m];

        for (int i = 0 ; i < m; i++) {
            String s = "";
            for (int j = 0 ; j < n; j++) {
                if (i == 0 || j == n - 1) 
                    s += ".";
                else
                    s += "#";
            }
            mat[i] = s;
        }

        return mat;
    }
}