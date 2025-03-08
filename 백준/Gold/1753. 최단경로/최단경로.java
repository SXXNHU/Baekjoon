import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<int[]>[] graph;
    static int[] dist;

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0], curNode = cur[1];

            if (curDist > dist[curNode]) continue;

            for (int[] edge : graph[curNode]) {
                int next = edge[0], cost = curDist + edge[1];

                if (cost < dist[next]) {
                    dist[next] = cost;
                    pq.offer(new int[]{cost, next});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) 
            sb.append(dist[i] == INF ? "INF\n" : dist[i] + "\n");
        
        System.out.print(sb);
    }
}
