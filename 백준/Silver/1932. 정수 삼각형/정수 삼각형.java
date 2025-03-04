import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) 
            for (int j = 0; j <= i; j++) 
                triangle[i][j] = sc.nextInt();
        
        for (int i = n - 2; i >= 0; i--) 
            for (int j = 0; j <= i; j++) 
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        
        System.out.println(triangle[0][0]);
        sc.close();
    }
}
