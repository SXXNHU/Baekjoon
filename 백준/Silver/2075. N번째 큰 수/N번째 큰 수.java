import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int ans = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        
        for(int i=0;i<N;i++){
            ans = pq.poll();
        }
        System.out.println(ans);
    }
}