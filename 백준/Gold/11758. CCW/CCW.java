import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        int ccw = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

        System.out.println(Integer.compare(ccw, 0));

        sc.close();
    }
}
