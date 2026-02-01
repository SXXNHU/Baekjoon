import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long[][] dp = new long[N][21];
        dp[0][arr[0]] = 1;
        
        for(int i=1; i<N-1 ;i++){
            int x = arr[i];
            for(int value = 0; value <=20; value++){
                if(dp[i-1][value] == 0) continue;
                
                int plus = value + x;
                if(plus <= 20){
                    dp[i][plus] = dp[i][plus] + dp[i-1][value];
                }
                
                int minus = value - x;
                if(minus >= 0){
                    dp[i][minus] = dp[i][minus] + dp[i-1][value];
                }
            }
        }
        System.out.println(dp[N-2][arr[N-1]]);
        
    }
}