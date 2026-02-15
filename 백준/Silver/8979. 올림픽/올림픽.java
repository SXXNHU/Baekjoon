import java.io.*;
import java.util.*;

public class Main{
    
    static int[][] nation;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        nation = new int[N+1][3];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            nation[n][0] = Integer.parseInt(st.nextToken());
            nation[n][1] = Integer.parseInt(st.nextToken());
            nation[n][2] = Integer.parseInt(st.nextToken());
        }
        
        int gold = nation[K][0];
        int silver = nation[K][1];
        int bronze = nation[K][2];
        int count=1;
        
        for(int i=1; i<=N;i++){
            if(nation[i][0] > gold) count ++;
            else if(nation[i][0] == gold && nation[i][1] > silver) count ++;
            else if(nation[i][0] == gold && nation[i][1] == silver && nation[i][2] > bronze) count ++;
        }
        System.out.println(count);
    }
}