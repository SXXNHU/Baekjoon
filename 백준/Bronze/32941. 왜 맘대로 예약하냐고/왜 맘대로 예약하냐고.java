import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int X = sc.nextInt();
        int N = sc.nextInt();

        boolean allCanAttend = true;

        for (int i = 0; i < N; i++) {
            int K = sc.nextInt();
            boolean canAttend = false;
            for (int j = 0; j < K; j++) {
                if (sc.nextInt() == X) {
                    canAttend = true;
                }
            }
            if (!canAttend) {
                allCanAttend = false;
            }
        }

        System.out.println(allCanAttend ? "YES" : "NO");
    }
}
