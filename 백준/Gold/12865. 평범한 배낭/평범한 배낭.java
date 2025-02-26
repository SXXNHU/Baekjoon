import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 물건의 개수, K: 배낭의 용량
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 물건의 무게와 가치
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        // 물건의 무게와 가치 입력 받기
        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        // DP 배열 초기화 (배낭 용량 0부터 K까지)
        int[] dp = new int[K + 1];

        // DP 배열을 갱신하면서 최대 가치를 구함
        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }

        // dp[K]가 배낭에 담을 수 있는 최대 가치
        System.out.println(dp[K]);

        sc.close();
    }
}
