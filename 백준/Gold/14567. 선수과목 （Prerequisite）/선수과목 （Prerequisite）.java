import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        int[] indeg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int later = Integer.parseInt(st.nextToken());
            list[pre].add(later);
            indeg[later]++;
        }

        int[] ans = new int[N + 1];
        Arrays.fill(ans, 1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : list[u]) {
                ans[v] = Math.max(ans[v], ans[u] + 1);
                indeg[v]--;
                if (indeg[v] == 0) q.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(ans[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
