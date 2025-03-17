import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int target = 1;
        for (int card : cards) {
            if (card == target) {
                target++;
            }
        }

        System.out.println(n - (target - 1));
    }
}
