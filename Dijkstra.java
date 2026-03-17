import java.util.*;

class Dijkstra {
    static class Pair {
        int node, dist;
        Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }

    static void dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) parent[i] = i;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;

            for (Pair nei : adj.get(u)) {
                int v = nei.node;
                int wt = nei.dist;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // output
        System.out.println("Distances: " + Arrays.toString(dist));
        System.out.println("Parents: " + Arrays.toString(parent));
    }
}