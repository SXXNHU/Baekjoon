import java.util.*;

public class Main {

    static int N;
    static int[] T,P;
    static int maxProfit = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(maxProfit);
    }

    static void dfs(int day, int profit) {
        if (day >= N) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        //상담을 하는 경우
        if (day + T[day] <= N) {
            dfs(day + T[day], profit + P[day]);
        }

        //상담을 하지않는 경우
        dfs(day + 1, profit);
    }
}