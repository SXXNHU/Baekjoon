import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.close();
        
        System.out.println(fact(n) / (fact(k) * fact(n - k)));
    }

    static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }
}
