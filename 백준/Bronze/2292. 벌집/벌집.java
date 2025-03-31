import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int layer = 1, count = 1;
        while (count < n) {
            count += 6 * layer;
            layer++;
        }
        System.out.println(layer);
    }
}
