import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt(), n = sc.nextInt();
            System.out.println(apartment(k, n));
        }
        sc.close();
    }

    static int apartment(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= k; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[k][n];
    }
}
