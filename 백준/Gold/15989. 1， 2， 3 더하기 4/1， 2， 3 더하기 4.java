import java.io.*;

public class Main {

    static int maxN = 10_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[maxN + 1];
        dp[0] = 1;

        int[] coins = {1, 2, 3};
        for (int c : coins) {
            for (int i = c; i <= maxN; i++) {
                dp[i] += dp[i - c];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
