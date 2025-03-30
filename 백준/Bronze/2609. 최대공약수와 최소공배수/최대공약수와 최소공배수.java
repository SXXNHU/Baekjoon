import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        sc.close();
        
        int gcd = gcd(a, b);
        int lcm = a * b / gcd;
        
        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
