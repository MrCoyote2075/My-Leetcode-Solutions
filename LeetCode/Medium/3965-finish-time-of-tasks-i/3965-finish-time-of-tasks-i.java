class Solution {
    public final long MIN = (long) -1e18;
    public final long MAX = (long) 1e18;
    
    public ArrayList<ArrayList<Integer>> grp;
    
    public long DFS (int u, int[] baseTime) {
        if (grp.get(u).isEmpty())
            return (long) baseTime[u];
        
        long latest = MIN;
        long earliest = MAX;
        
        for (int v : grp.get(u)) {
            long val = DFS(v, baseTime);
            
            latest = Math.max(latest, val);
            earliest = Math.min(earliest, val);
        }

        long ownDuration = (latest - earliest) + baseTime[u];
        
        return latest + ownDuration;
    }
    
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        grp = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++)
            grp.add(new ArrayList<>());
        
        for (int[] ed : edges)
            grp.get(ed[0]).add(ed[1]);

        
        return DFS (0, baseTime);
    }
}