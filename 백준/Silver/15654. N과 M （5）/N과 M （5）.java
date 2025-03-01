import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void backtrack(int depth) {
        if (depth == M) { 
            for (int num : path) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { 
                visited[i] = true;
                path.add(arr[i]);
                backtrack(depth + 1);
                path.remove(path.size() - 1); 
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); 

        backtrack(0);
        System.out.print(sb); 
    }
}
