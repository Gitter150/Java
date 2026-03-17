import java.util.*;

class Main {

    static class Pair {
        int node, wt;
        Pair(int n, int w) {
            node = n;
            wt = w;
        }
    }

    static void dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) parent[i] = i;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;

            for (Pair it : adj.get(u)) {
                int v = it.node;
                int w = it.wt;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Distances: " + Arrays.toString(dist));
        System.out.println("Parents: " + Arrays.toString(parent));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // vertices
        int E = sc.nextInt(); // edges

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // input edges: u v w
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if directed
        }

        int src = sc.nextInt();

        dijkstra(V, adj, src);
    }
}