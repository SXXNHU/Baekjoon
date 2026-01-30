import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n]; 
        for(int i=0; i <n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        final int INF = 1_000_000_000;
        //최소값이니 dp[1]부터는 INF로 초기화
        for(int i=1;i<=k; i++){
            dp[i] = INF;
        }
        dp[0] = 0;
        
        for(int c : coins){
            if(c > k) continue;
            for(int x=c; x<=k ;x++){
                if(dp[x-c] != INF){
                    dp[x] = Math.min(dp[x], dp[x-c] + 1);
                }
            }
        }
        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}