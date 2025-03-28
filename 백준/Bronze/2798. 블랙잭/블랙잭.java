import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 개수
        int M = sc.nextInt(); // 목표 합
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int maxSum = 0;
        
        // 세 개의 카드를 고르는 모든 경우의 수 확인
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        
        System.out.println(maxSum);
        sc.close();
    }
}
