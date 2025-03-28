import java.util.Scanner;

public class Main {
    static final int INF = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        int result = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];

            for (int i = 0; i < 3; i++) {
                dp[0][i] = (i == firstColor) ? cost[0][i] : INF;
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    result = Math.min(result, dp[n - 1][lastColor]);
                }
            }
        }

        System.out.println(result);
    }
}
