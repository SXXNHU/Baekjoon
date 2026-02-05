import java.io.*;
import java.util.*;

public class Main {

    static String encoder(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] goal = arr.clone();
        Arrays.sort(goal);

        String start = encoder(arr);
        String target = encoder(goal);

        if (start.equals(target)) {
            System.out.println(0);
            return;
        }

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> distMap = new HashMap<>();

        q.offer(start);
        distMap.put(start, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int dist = distMap.get(cur);

            String[] parts = cur.split(",");
            int[] x = new int[N];
            for (int i = 0; i < N; i++) x[i] = Integer.parseInt(parts[i]);

            // 가능한 모든 뒤집기 시도하고
            for (int i = 0; i <= N - K; i++) {
                int[] y = x.clone();

                // 구간 뒤집기
                for (int l = i, r = i + K - 1; l < r; l++, r--) {
                    int tmp = y[l];
                    y[l] = y[r];
                    y[r] = tmp;
                }

                String next = encoder(y);

                if (distMap.containsKey(next)) continue;

                if (next.equals(target)) {
                    System.out.println(dist + 1);
                    return;
                }

                distMap.put(next, dist + 1);
                q.offer(next);
            }
        }

        System.out.println(-1);
    }
}
