    import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][2];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        final int INF = 1_000_000_000;
        
        int[] dp = new int[C+100+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i=0; i<N ;i++){
            int cost = arr[i][0];
            int people = arr[i][1];
            for(int x=people; x<= C+100; x++){
                if(dp[x-people] != INF){
                    dp[x] = Math.min(dp[x], dp[x-people] + cost);
                }
            }
        }
        int answer = INF; 
        for(int x=C; x <= C+100; x++){
            answer = Math.min(answer, dp[x]);
        }
        System.out.println(answer);
    }
}