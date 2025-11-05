import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(prefix[r] - prefix[l - 1]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
