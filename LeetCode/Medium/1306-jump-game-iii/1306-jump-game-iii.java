class Solution {
    public int n;
    public boolean[] vis;
    
    public boolean DFS(int u, int[] arr) {
        if (vis[u])
            return false;
        
        if (arr[u] == 0)
            return true;

        vis[u] = true;
        
        if (u + arr[u] < n && DFS(u + arr[u], arr))
            return true;

        if (0 <= u - arr[u] && DFS(u - arr[u], arr))
            return true;

        return false;
    }
    
    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        vis = new boolean[n];

        return DFS(start, arr);
    }
}