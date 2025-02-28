import java.util.Scanner;

public class Main {
    static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        dfs(1, 0, new int[M]); // 1부터 시작, 깊이 0, 숫자 저장 배열
    }

    static void dfs(int start, int depth, int[] arr) {
        if (depth == M) { // M개 선택 완료
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;  // 현재 깊이에 숫자 저장
            dfs(i + 1, depth + 1, arr); // 다음 숫자는 i+1부터 선택
        }
    }
}
