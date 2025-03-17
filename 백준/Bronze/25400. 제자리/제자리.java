import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = 1; 
        int count = 0; 

        for (int i = 0; i < n; i++) {
            int card = sc.nextInt();
            if (card == target) {
                target++;
            } else {
                count++;
            }
        }

        System.out.println(count);
    }
}
