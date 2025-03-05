import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                sb.append(Math.max(stickers[0][0], stickers[1][0])).append("\n");
                continue;
            }

            int[][] dp = new int[2][n];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], (i > 1 ? dp[1][i - 2] : 0)) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], (i > 1 ? dp[0][i - 2] : 0)) + stickers[1][i];
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.print(sb);
    }
}
