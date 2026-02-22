import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> cntMap = new HashMap<>(M * 2);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            long[] row = new long[N];

            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                row[j] = (((long) v) << 32) | j; // value + idx 패킹
            }

            Arrays.sort(row);

            int[] rank = new int[N];
            int r = 0;

            int prevVal = (int) (row[0] >> 32);
            int idx0 = (int) row[0];
            rank[idx0] = 0;

            for (int k = 1; k < N; k++) {
                int val = (int) (row[k] >> 32);
                if (val != prevVal) {
                    r++;
                    prevVal = val;
                }
                int idx = (int) row[k];
                rank[idx] = r;
            }

            StringBuilder sb = new StringBuilder(N * 3);
            for (int j = 0; j < N; j++) {
                sb.append(rank[j]).append(' ');
            }
            String key = sb.toString();
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (int c : cntMap.values()) {
            ans += (long) c * (c - 1) / 2;
        }
        System.out.println(ans);
    }
}