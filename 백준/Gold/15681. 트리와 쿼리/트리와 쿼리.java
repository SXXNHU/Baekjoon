import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        // 루트 R부터 DFS 탐색하여 각 노드의 서브트리 정점 수 계산
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[queryNode]).append('\n');
        }

        System.out.print(sb);
    }

    private static int dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1; // 자기 자신 포함
        for (int next : tree[node]) {
            if (!visited[next]) {
                subtreeSize[node] += dfs(next);
            }
        }
        return subtreeSize[node];
    }
}
