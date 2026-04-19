class Solution {
    public int n; 
    public int m;
    public int[] parent; 
    public int count = 0;

    public int index (int i, int j) {
        return m * i + j;
    }

    public int find (int u) {
        if (u == parent[u])
            return u;

        return parent[u] = find (parent[u]);
    }

    public void union (int u, int v) {
        int parU = find(u);
        int parV = find(v);

        if (parU == parV)
            return;
        
        parent[parU] = parV;
        count--;
    }

    public static int[] dir = {0, -1};
    public static int[] dic = {-1, 0};

    public void merge (int i, int j, char[][] grid) {
        count++;
        for (int d = 0; d < 2 ; d++) {
            int nr = i + dir[d];
            int nc = j + dic[d];

            if (0 <= nr && 0 <= nc && nr < n && nc < m && grid[nr][nc] == '1')
                union(index(nr, nc), index(i, j));
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        parent = new int[n * m + 1];

        for (int i = 0 ; i < parent.length ; i++) 
            parent[i] = i;

        for (int i = 0 ; i < n ; i++) 
            for (int j = 0 ; j < m ; j++) 
                if (grid[i][j] == '1')
                    merge(i, j, grid);
        
        return count;
    }
}