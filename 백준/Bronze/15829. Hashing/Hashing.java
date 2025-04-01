import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        sc.close();

        long hash = 0, r = 1, m = 1234567891;
        for (int i = 0; i < n; i++) {
            hash = (hash + (str.charAt(i) - 'a' + 1) * r) % m;
            r = (r * 31) % m;
        }
        System.out.println(hash);
    }
}
