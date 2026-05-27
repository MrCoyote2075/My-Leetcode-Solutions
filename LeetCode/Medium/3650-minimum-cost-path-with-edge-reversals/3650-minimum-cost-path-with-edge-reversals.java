class Solution {
    public final int INF = (int) 1e9;
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> grp = new ArrayList<>();

        for(int i = 0; i < n ; i++) 
            grp.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            grp.get(u).add(new int[]{v, w});
            grp.get(v).add(new int[]{u, 2 * w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0] = 0;
        PQ.offer(new int[]{0, 0});

        while (!PQ.isEmpty()) {
            int[] cur = PQ.poll();
            int d = cur[0];
            int u = cur[1];

            if (dist[u] > d)
                continue;

            for (int[] ed : grp.get(u)) {
                int v = ed[0];
                int w = ed[1];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    PQ.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist[n - 1] == INF ? -1 : dist[n - 1];
    }
}