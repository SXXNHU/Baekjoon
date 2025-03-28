import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] house;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        dp = new int[N][N][3]; // 0: 가로, 1: 세로, 2: 대각선

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 상태: (0, 1) 위치에 가로로 놓여 있음
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (house[i][j] == 1) continue; // 벽이면 넘어감

                // 가로로 오는 경우
                if (j - 1 >= 0) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                // 세로로 오는 경우
                if (i - 1 >= 0) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 대각선으로 오는 경우
                if (i - 1 >= 0 && j - 1 >= 0 && house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        int result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(result);
    }
}
