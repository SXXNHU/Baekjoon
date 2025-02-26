import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 두 문자열 입력 받기
        String str1 = sc.next();
        String str2 = sc.next();

        // dp 배열 초기화
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // dp 배열 채우기
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS의 길이 출력
        System.out.println(dp[str1.length()][str2.length()]);
        
        sc.close();
    }
}
