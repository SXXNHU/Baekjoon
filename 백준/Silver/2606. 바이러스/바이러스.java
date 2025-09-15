import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine().trim()); // 연결 수

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= n; i++) Collections.sort(adj[i]);

        boolean[] visited = new boolean[n + 1];
        int infected = bfs(1, adj, visited);

        System.out.println(infected - 1);
    }

    private static int bfs(int start, List<Integer>[] adj, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nxt : adj[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
        return count;
    }
}
